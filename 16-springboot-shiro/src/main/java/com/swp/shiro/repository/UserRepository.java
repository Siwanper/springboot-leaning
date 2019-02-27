package com.swp.shiro.repository;

import com.swp.shiro.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-02-22 3:19 PM
 */
public interface UserRepository extends JpaRepository<SysUser , Integer> {
    // 根据用户名查找用户
    SysUser findByUsername(String username);

    SysUser findByUsernameAndPassword(String username, String password);
}
