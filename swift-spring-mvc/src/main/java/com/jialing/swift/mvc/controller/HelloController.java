package com.jialing.swift.mvc.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @RequestMapping("/index/{id}")
    public String index(@PathVariable Integer id, String name) {
        return "id=" + id + ", name=" + name;
    }
}
