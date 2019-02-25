package com.swp.shiro.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-02-22 3:02 PM
 */
@Entity
public class SysRole implements Serializable {

    private static final long serialVersionUID = 4305847221310489365L;
    @Id
    @GeneratedValue
    private Integer id;
    // 角色名称
    private String name;
    // 角色
    private String role;
    // 角色描述
    private String description;
    // 角色是否可用
    private boolean available;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sys_role_permission", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
    // 角色所拥有的权限
    private List<SysPermission> permissions;

    @ManyToMany
    @JoinTable(name = "sys_user_role", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "uid"))
    // 用户该角色的用户
    private List<SysUser> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public List<SysUser> getUsers() {
        return users;
    }

    public void setUsers(List<SysUser> users) {
        this.users = users;
    }
}
