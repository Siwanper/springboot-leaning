package com.swp.mongodb.service;

import com.swp.mongodb.model.User;

public interface UserDao {

    public void saveUser(User user);

    public User findUserByUsername(String username);

    public void updateUser(User user);

    public void deleteUser(Long id);

}
