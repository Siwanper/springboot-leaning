package com.swp.shiro.core.realm;

import com.swp.shiro.model.SysPermission;
import com.swp.shiro.model.SysRole;
import com.swp.shiro.model.SysUser;
import com.swp.shiro.repository.UserRepository;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-02-22 3:55 PM
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserRepository repository;

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

        String username = (String) authenticationToken.getPrincipal();

        SysUser user = repository.findByUsername(username);

        if (null == user) {
            return null;
        } else if (user.getState() == 2){
            throw new DisabledAccountException("账户被禁用");
        }


        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), getName());

        return simpleAuthenticationInfo;
    }
}
