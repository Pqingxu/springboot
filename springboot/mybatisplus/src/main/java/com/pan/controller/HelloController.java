package com.pan.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author qingxu.pan@tophant.com
 * @Date 2022/4/16
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping()
    public String hello(){
        return "hello";
    }

}
