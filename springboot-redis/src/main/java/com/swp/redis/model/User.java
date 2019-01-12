package com.swp.redis.model;

import java.io.Serializable;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-12 3:14 PM
 */
public class User implements Serializable {

    private static final long serialVersionUID = -7627340700666948418L;

    private String id;
    private String username;
    private Integer age;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
