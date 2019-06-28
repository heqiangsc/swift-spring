package com.jialing.swift.mvc.advicer;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestControllerAdvicer {


    @ExceptionHandler(value = {Exception.class
    })
    public Object handleNPE(
            Throwable throwable) {
        Map<String,Object> data = new HashMap<>();
        data.put("message",throwable.getMessage());
        return data;
    }
}
