package com.swp.mybatisxml.mapper;

import com.swp.mybatisxml.model.User;

import java.util.List;

public interface UserMapper {

    List<User> getAllUser();

    User getUser(int uid);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(int uid);
}
