package com.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author qingxu.pan@tophant.com
 * @Date 2022/4/11
 */

@RestController
@RequestMapping("/hello")
@Slf4j
@Api(value = "你好我的世界" , tags = "My World!")
public class HelloController {

    @GetMapping
    public String hello(){
        return "Hello";
    }
}
