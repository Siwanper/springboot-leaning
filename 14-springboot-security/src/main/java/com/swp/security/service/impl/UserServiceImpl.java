package com.swp.security.service.impl;

import com.swp.security.model.SysUser;
import com.swp.security.repository.UserRepository;
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
 * @create 2019-01-30 3:27 PM
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public SysUser findByUsername(String username) {
        return repository.findByUsername(username);
    }

}
