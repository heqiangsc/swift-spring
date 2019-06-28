package com.jialing.swift.mvc.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {


    @RequestMapping("/index/{id}")
    public String index(@PathVariable Integer id, String name) {
        return "id=" + id + ", name=" + name;
    }


    /**
     * 处理页面找不到的情况
     * @param status
     * @param request
     * @param throwable
     * @return
     */
    @GetMapping("/404.html")
    public Map<String,Object> handlePageNotFound(HttpStatus status,
                                                 HttpServletRequest request,
                                                 Throwable throwable) {

        Map<String,Object> errors = new HashMap<>();

        errors.put("statusCode",
                request.getAttribute("javax.servlet.error.status_code"));
        errors.put("requestUri",
                request.getAttribute("javax.servlet.error.request_uri"));

        return errors;
    }
}
