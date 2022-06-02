package com.helloword.controller;

import com.helloword.entity.Person;
import com.helloword.util.PropertyUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;


@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }


    @RequestMapping("test")
    public Object test(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("1-1","213");
        map.put("qing","xu");
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("1-1","213");
        map2.put("qing","xu");

        ArrayList<Object> list = new ArrayList<>();
        list.add(map);
        list.add(map2);


        Object generate = PropertyUtils.generate(map);
        System.out.println(generate);
        return list;
    }

    @GetMapping("test/{id}")
    public String testId(@PathVariable("id") String id){
        return id;
    }

    @PostMapping("person")
    public String getPerson( @Valid @RequestBody Person person){
        return person.toString();
    }

}
