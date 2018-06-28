package com.cralor.ch3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by cc.
 * 2018/6/13 14:08
 **/
@RestController
public class TestController {

    @GetMapping("test")
    public ModelAndView test(){
        return new ModelAndView("redirect:login.html");
    }
/*
    @GetMapping("test")
    public String test(){
        return "hello";
    }
*/
}
