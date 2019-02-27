package com.swp.shiro.core.filter;

import com.swp.shiro.model.SysUser;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-02-26 10:42 AM
 */
public class KickoutSessionControlFilter extends AccessControlFilter{

    // 提出后跳转的连接
    private String kickoutUrl;
    // 提出之前登录的用户还是提出以后登录的用户 默认 踢出之前登录的用户
    private boolean kickoutAfter = false;
    // 同时在线的用户 默认 1
    private int maxSession = 1;

    private SessionManager sessionManager;

    private Cache<String , Deque<Serializable>> cache;

    public void setKickoutUrl(String kickoutUrl) {
        this.kickoutUrl = kickoutUrl;
    }

    public void setKickoutAfter(boolean kickoutAfter) {
        this.kickoutAfter = kickoutAfter;
    }

    public void setMaxSession(int maxSession) {
        this.maxSession = maxSession;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cache = cacheManager.getCache("shiro_redis_cache");
    }

    /**
     * 表示是否允许访问；mappedValue就是[urls]配置中拦截器参数部分，如果允许访问返回true，否则false；
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    /**
     * 表示当访问拒绝时是否已经处理了；如果返回true表示需要继续处理；如果返回false表示该拦截器实例已经处理了，将直接返回即可。
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        System.out.println(" ======= onAccessDenied ========== ");
        Subject subject = getSubject(servletRequest, servletResponse);
        if (!subject.isAuthenticated() && !subject.isRemembered()) {
            // 如果没有登录，直接进行之后的流程
            return true;
        }
        // 获取当前登录的用户
        SysUser user = (SysUser) subject.getPrincipal();
        String username = user.getUsername();
        // 获取当前登录的用户 sessionID
        Session session = subject.getSession();
        Serializable sessionId = session.getId();
        // 获取之前缓存的当前用户sessionID队列，如果没有，就新建缓存队列。
        Deque<Serializable> sessionIds = cache.get(username);
        //如果此用户没有session队列，也就是还没有登录过，缓存中没有
        //就new一个空队列，不然deque对象为空，会报空指针
        if(sessionIds==null){
            sessionIds = new LinkedList<Serializable>();
        }
        // 如果用户没在队列中，却用户没有被踢出，则放入队列，并刷新缓存。
        if (!sessionIds.contains(sessionId) && session.getAttribute("kickout") == null) {
            sessionIds.push(sessionId);
            cache.put(username, sessionIds);
        }

        // 如果队列的长度超过最大限制，则要踢出用户
        while (sessionIds.size() > maxSession) {
            Serializable kickoutSessionId = null;
            if (kickoutAfter) { // 踢出后边登录的用户
                kickoutSessionId = sessionIds.removeFirst();
           } else { // 踢出最开始登录的用户
                kickoutSessionId = sessionIds.removeLast();
            }
            // 更新缓存
            cache.put(username, sessionIds);

            // 获取被踢出的session，并标记为提出用户
            Session kickoutSession = sessionManager.getSession(new DefaultSessionKey(kickoutSessionId));
            if (kickoutSession != null) {
                kickoutSession.setAttribute("kickout", true);
            }
        }

        // 如果该用户是踢出用户，则跳转到指定的页面
        if ((Boolean) session.getAttribute("kickout") != null && (Boolean) session.getAttribute("kickout") == true) {
            // 退出登录
            subject.logout();

            saveRequest(servletRequest);
            // 重新登录
            WebUtils.issueRedirect(servletRequest, servletResponse, kickoutUrl);
            // 直接返回，不再继续处理
            return false;
        }
        return true;
    }
}
