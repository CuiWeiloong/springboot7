package com.cralor.ch1.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cc.
 * 2018/6/12 17:19
 **/
@RestController
public class UserReditRestController {

    @GetMapping("usercredit/{id}")
    public String getCreditLevel(@PathVariable String id){
        //模拟id用户的信用等级
        return "用户id为 "+id+" 的信用等级为：3";
    }
}
