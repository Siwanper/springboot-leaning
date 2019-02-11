package com.swp.security.service;

import com.swp.security.model.SysUser;

public interface UserService {

    public SysUser findByUsername(String username);
}
