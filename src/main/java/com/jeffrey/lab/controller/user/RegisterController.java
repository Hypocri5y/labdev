package com.jeffrey.lab.controller.user;

import com.jeffrey.lab.req.user.UserRegisterReq;
import com.jeffrey.lab.resp.CommonResp;
import com.jeffrey.lab.service.user.RegisterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @program: lab
 * @author: Jeffrey
 * @create: 2025-04-02 21:11
 * @description:
 **/
@RestController
@RequestMapping(value = "/user")
public class RegisterController {

    @Resource
    private RegisterService registerService;

    @PostMapping(value = "/register")
    public CommonResp register(@Valid @RequestBody UserRegisterReq req) {
        return registerService.register(req);
    }

}
