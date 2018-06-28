package com.cralor.ch1.entity;

import org.springframework.stereotype.Component;

/**
 * Created by cc.
 * 2018/6/12 17:19
 **/

@Component
public class Person {

    private String name="xiaoming";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
