package com.helloword.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.ResponseWrapper;


@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }
}
