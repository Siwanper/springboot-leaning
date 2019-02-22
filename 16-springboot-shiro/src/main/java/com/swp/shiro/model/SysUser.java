package com.swp.shiro.model;

import javax.persistence.*;
import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-02-22 2:57 PM
 */
@Entity
public class SysUser {

    @Id
    @GeneratedValue
    // 用户ID
    private Integer uid;
    // 用户昵称
    private String name;

    @Column(unique = true)
    // 用户账号
    private String username;
    // 用户密码
    private String password;
    // 密码加密盐
    private String salt;
    // 用户状态  0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
    private byte state;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sys_user_role", joinColumns = @JoinColumn(name = "uid"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    // 用户所拥有的角色
    private List<SysRole> roles;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                ", roles=" + roles +
                '}';
    }

    public String getCredentialsSalt(){
        return username + salt;
    }
}
