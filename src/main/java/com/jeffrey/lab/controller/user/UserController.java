package com.jeffrey.lab.controller.user;

import com.jeffrey.lab.domain.User;
import com.jeffrey.lab.service.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: lab
 * @author: Jeffrey
 * @create: 2025-04-02 16:19
 * @description:
 **/
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/user/list")
    public List<User> getUserList() {
        return userService.select();
    }
}
