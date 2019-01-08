package com.swp.thymeleaf.model;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-03 5:30 PM
 */
public class User {

    private String username;
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
