package com.swp.dockercompose.model;

import javax.persistence.*;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-05-25 1:02 PM
 */
@Entity
public class Visitor {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String ip;
    @Column(nullable = false)
    private Integer times;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}
