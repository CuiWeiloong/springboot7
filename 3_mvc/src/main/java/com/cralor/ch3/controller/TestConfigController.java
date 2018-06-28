package com.cralor.ch3.controller;

import com.cralor.ch3.entity.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cc.
 * 2018/6/13 14:08
 **/
@RestController
public class TestConfigController {

    @RequestMapping("admin/ss")
    public String  testc(){


        return "success";
    }

}
