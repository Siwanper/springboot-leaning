package com.swp.rabbitmq.model;

import java.io.Serializable;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-16 11:12 AM
 */
public class User implements Serializable {

    private String name;

    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

}
