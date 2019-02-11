package com.swp.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-30 3:06 PM
 */

@Entity
public class SysUser implements Serializable, UserDetails {

    private static final long serialVersionUID = 8387005578175311809L;
    @Id
    @GeneratedValue
    private Integer uid;

    private String username;

    private String password;

    private Integer status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SYS_USER_ROLE", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private List<SysRole> roles;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        List<SysRole> roles = getRoles();
        for (SysRole role : roles) {
            for (SysPermission permission : role.getPermissions()) {
                auths.add(new SimpleGrantedAuthority(permission.getUrl()));
            }
        }
        return auths;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", roles=" + roles +
                '}';
    }

}
