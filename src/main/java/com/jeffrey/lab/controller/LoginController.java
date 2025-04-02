package com.jeffrey.lab.controller;

import com.jeffrey.lab.req.UserLoginReq;
import com.jeffrey.lab.resp.CommonResp;
import com.jeffrey.lab.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @program: lab
 * @author: Jeffrey
 * @create: 2025-04-02 17:18
 * @description:
 **/
@RequestMapping(value = "/user")
@ResponseBody
@Controller
public class LoginController {

    @Resource
    private LoginService loginService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public CommonResp login(@Valid @RequestBody UserLoginReq req) {
        return loginService.login(req);
    }
}
