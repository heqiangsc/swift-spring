package com.jialing.swift.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {


    @RequestMapping("/thymeleaf")
    public String index() {
        return "index";
    }


}
