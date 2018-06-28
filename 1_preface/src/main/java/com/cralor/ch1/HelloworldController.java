package com.cralor.ch1;

import com.cralor.ch1.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * Created by cc.
 * 2018/6/12 17:19
 **/
@RestController
public class HelloworldController {

    @Autowired
    Person person;

    @GetMapping("hello.html")
    public String hello(){
        return "hello springboot!";
    }
    @GetMapping("test")
    public String test(){
        return person.getName();
    }
}
