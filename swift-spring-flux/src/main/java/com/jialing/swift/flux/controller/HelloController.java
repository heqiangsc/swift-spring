package com.jialing.swift.flux.controller;

import com.jialing.swift.flux.entity.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello/index")
    public Person index() {
        Person p = new Person();
        p.setId(1);
        p.setName("张三");
        return p;
    }
}
