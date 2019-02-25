package com.swp.shiro.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-02-22 3:03 PM
 */
@Entity
public class SysPermission implements Serializable {

    private static final long serialVersionUID = -1376913067461079976L;
    @Id
    @GeneratedValue
    private Integer id;
    // 权限名
    private String name;
    // 权限
    private String permission;
    // 描述
    private String description;
    // 权限类型
    private String resource_type;
    // 连接
    private String url;
    // 父节点id
    private Integer parent_id;
    // 父节点所有id
    private String parent_ids;
    // 权限是否可用
    private boolean available;
    @ManyToMany
    @JoinTable(name = "sys_role_permission", joinColumns = @JoinColumn(name = "permission_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<SysRole> roles;

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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResource_type() {
        return resource_type;
    }

    public void setResource_type(String resource_type) {
        this.resource_type = resource_type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getParent_ids() {
        return parent_ids;
    }

    public void setParent_ids(String parent_ids) {
        this.parent_ids = parent_ids;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
