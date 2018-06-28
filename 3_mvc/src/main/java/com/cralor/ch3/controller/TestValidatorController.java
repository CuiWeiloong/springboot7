package com.cralor.ch3.controller;

import com.cralor.ch3.entity.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by cc.
 * 2018/6/13 14:08
 **/
@RestController
public class TestValidatorController {

    @RequestMapping("testva")
    public String  test(@Validated User user, BindingResult result){

        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            FieldError error = (FieldError) list.get(0);
            System.out.println(error.getObjectName()+","+error.getField()+","+error.getDefaultMessage());
            return "has error";
        }
        return "success";
    }

}
