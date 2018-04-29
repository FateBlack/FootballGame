package com.cxjd.footballgame.bean;

import org.litepal.crud.DataSupport;

/**
 * Created by 白 on 2018/4/29.
 */

public class User extends DataSupport {

    private Integer id;

    private String name;

    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
