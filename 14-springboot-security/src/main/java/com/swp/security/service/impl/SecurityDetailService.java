package com.swp.security.service.impl;

import com.swp.security.model.SysUser;
import com.swp.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-30 4:34 PM
 */
@Service
public class SecurityDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("未检查到用户： " + username);
        }
        return user;
    }
}
