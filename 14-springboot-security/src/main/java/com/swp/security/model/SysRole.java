package com.swp.security.model;

import javax.persistence.*;
import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-30 3:06 PM
 */
@Entity
public class SysRole {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String role;

    private String description;

    private Integer status;

    @ManyToMany
    @JoinTable(name = "SYS_USER_ROLE", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<SysUser> users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SYS_ROLE_PERMISSION", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private List<SysPermission> permissions;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<SysUser> getUsers() {
        return users;
    }

    public void setUsers(List<SysUser> users) {
        this.users = users;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", users=" + users +
                ", permissions=" + permissions +
                '}';
    }
}
