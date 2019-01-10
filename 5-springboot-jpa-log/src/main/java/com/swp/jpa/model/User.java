package com.swp.jpa.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-09 10:51 AM
 */
@Table(name = "tb_user")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long uid;
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(name = "user_password", nullable = false)
    private String userPassword;
    @Column(name = "user_sex")
    private int userSex;
    @Column(name = "user_birthday")
    private Date userBirthday;
    @Column(name = "user_reg_time")
    private Date userRegTime;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Date getUserRegTime() {
        return userRegTime;
    }

    public void setUserRegTime(Date userRegTime) {
        this.userRegTime = userRegTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex=" + userSex +
                ", userBirthday=" + userBirthday +
                ", userRegTime=" + userRegTime +
                '}';
    }
}
