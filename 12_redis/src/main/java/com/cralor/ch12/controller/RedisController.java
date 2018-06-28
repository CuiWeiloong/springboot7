package com.cralor.ch12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cc.
 * 2018/6/19 9:27
 **/
@RestController
@RequestMapping("strredis")
public class RedisController {

    @Autowired
    private StringRedisTemplate redisClient;

    @GetMapping("setget.html")
    public String env(String para){
        redisClient.opsForValue().set("testenv",para);
        String str=redisClient.opsForValue().get("testenv");
        return str;
    }
}
