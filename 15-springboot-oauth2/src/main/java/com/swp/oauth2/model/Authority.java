package com.swp.oauth2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-02-19 3:19 PM
 */
@Entity
public class Authority {


    @Id
    @NotNull
    @Size(min = 0, max = 50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
