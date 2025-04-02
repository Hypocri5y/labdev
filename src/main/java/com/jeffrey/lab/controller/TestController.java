package com.jeffrey.lab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: lab
 * @author: Jeffrey
 * @create: 2025-04-02 15:11
 * @description:
 **/
@RestController()
public class TestController {

    @RequestMapping("/t1")
    public String hello(){
        return "helloword!";
    }
}
