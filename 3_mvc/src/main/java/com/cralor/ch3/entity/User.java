package com.cralor.ch3.entity;

import javax.validation.constraints.NotNull;

/**
 * Created by cc.
 * 2018/6/14 11:08
 **/
public class User {

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
