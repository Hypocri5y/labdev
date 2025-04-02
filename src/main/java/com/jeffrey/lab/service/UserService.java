package com.jeffrey.lab.service;

import com.jeffrey.lab.domain.User;
import com.jeffrey.lab.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: lab
 * @author: Jeffrey
 * @create: 2025-04-02 16:16
 * @description:
 **/
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;


    public List<User> select(){
        return userMapper.selectByExample(null);
    }
}
