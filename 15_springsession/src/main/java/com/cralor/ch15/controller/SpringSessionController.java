package com.cralor.ch15.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cc.
 * 2018/6/19 14:54
 **/
@RestController
public class SpringSessionController {

    @Autowired
    RedisTemplate redisTemplate;
    Log log = LogFactory.getLog(SpringSessionController.class);

    @RequestMapping("/putsession.html")
    public String putSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        log.info(session.getClass());
        log.info(session.getId());
        String name = "xiandafu";
        session.setAttribute("user", name);
        redisTemplate.opsForValue().set("why", "ccccc");
        return "hey,"+name;
    }
}
