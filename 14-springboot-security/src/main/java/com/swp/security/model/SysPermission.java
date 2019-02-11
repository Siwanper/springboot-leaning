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
public class SysPermission {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String description;

    private String url;

    private Integer status;

    private Integer parent;

    @ManyToMany
    @JoinTable(name = "SYS_ROLE_PERMISSION", joinColumns = { @JoinColumn(name = "permission_id") }, inverseJoinColumns = {@JoinColumn(name = "role_id")})
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", status=" + status +
                ", parent=" + parent +
                ", roles=" + roles +
                '}';
    }
}
