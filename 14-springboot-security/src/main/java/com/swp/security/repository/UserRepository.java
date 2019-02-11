package com.swp.security.repository;

import com.swp.security.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SysUser, Integer> {

    public SysUser findByUsername(String username);

}
