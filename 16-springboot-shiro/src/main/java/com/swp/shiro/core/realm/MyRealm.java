package com.swp.shiro.core.realm;

import com.swp.shiro.model.SysPermission;
import com.swp.shiro.model.SysRole;
import com.swp.shiro.model.SysUser;
import com.swp.shiro.repository.UserRepository;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-02-22 3:55 PM
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserRepository repository;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    // 登录的次数
    private static final String LOGIN_COUNT = "LOGIN_COUNT";
    // 登录被锁
    private static final String LOGIN_LOCK = "LOGIN_LOCK";
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        for (SysRole role : user.getRoles()) {
            simpleAuthorizationInfo.addRole(role.getRole());
            for (SysPermission permission : role.getPermissions()) {
                simpleAuthorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 验证
     * 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("MyRealm -> doGetAuthenticationInfo");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());

        // 使用redis 记住用户点击登录的次数，实现登录失败次数限制
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        // 每登录一次，加一次
        opsForValue.increment(LOGIN_COUNT + username, 1);
        String loginCount = opsForValue.get(LOGIN_COUNT + username);
        // 如果失败次数超过限制，被锁一个小时
        if (Integer.parseInt(loginCount) > 5){
            opsForValue.set(LOGIN_LOCK + username, "LOCK");
            stringRedisTemplate.expire(LOGIN_LOCK + username, 1, TimeUnit.MINUTES);
        }
        // 如果用户被锁抛出异常
        if ("LOCK".equals(opsForValue.get(LOGIN_LOCK + username))) {
            throw new DisabledAccountException("由于密码输入错误次数大于5次，帐号已经禁止登录！");
        }

        // 密码加密
        String algorithmName = "MD5";
        String salt = username + "8d78869f470951332959580424d4bf4f";
        int hashIterations = 2;
        SimpleHash simpleHash = new SimpleHash(algorithmName, password, salt, hashIterations);
        String md5Password = simpleHash.toString();

        SysUser user = repository.findByUsernameAndPassword(username, md5Password);

        if (null == user) {
            return null;
        } else if (user.getState() == 2){
            throw new DisabledAccountException("账户被禁用");
        } else {
            System.out.println("登录成功");
            // 清除记录的登录次数
            opsForValue.set(LOGIN_COUNT + username, "0");

        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), getName());

        return simpleAuthenticationInfo;
    }
}
