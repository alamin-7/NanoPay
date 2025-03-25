package com.nanoPay.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    public String test(){
        return "This is the front page";
    }
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello";
    }
}
