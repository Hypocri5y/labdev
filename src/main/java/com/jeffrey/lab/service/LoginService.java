package com.jeffrey.lab.service;

import com.jeffrey.lab.domain.User;
import com.jeffrey.lab.domain.UserExample;
import com.jeffrey.lab.mapper.UserMapper;
import com.jeffrey.lab.req.UserLoginReq;
import com.jeffrey.lab.resp.CommonResp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: lab
 * @author: Jeffrey
 * @create: 2025-04-02 17:18
 * @description:
 **/
@Service
public class LoginService {
    @Resource
    private UserMapper userMapper;
    public CommonResp login(UserLoginReq userLoginReq) {
        String loginName = userLoginReq.getLoginName();
        String password = userLoginReq.getPassword();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserAccountEqualTo(loginName);
        //因为登录名唯一，所以是1或null
        List<User> users = userMapper.selectByExample(userExample);
        CommonResp<User> commonResp = new CommonResp<>();
        if (users.size() == 0) {
            commonResp.setIsSuccess(false);
            commonResp.setMessage("用户名不存在");
            return commonResp;
        }else {
            User user = users.get(0);
            if (user.getUserPwd().equals(password)) {
                commonResp.setContent(user);
                return commonResp;
            }else {
                commonResp.setIsSuccess(false);
                commonResp.setMessage("密码错误");
                return commonResp;
            }
        }
    }
}
