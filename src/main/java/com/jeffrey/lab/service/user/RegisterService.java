package com.jeffrey.lab.service.user;

import com.jeffrey.lab.domain.User;
import com.jeffrey.lab.domain.UserExample;
import com.jeffrey.lab.mapper.UserMapper;
import com.jeffrey.lab.req.user.UserRegisterReq;
import com.jeffrey.lab.resp.CommonResp;
import com.jeffrey.lab.util.CopyUtil;
import com.jeffrey.lab.util.SnowFlakeSmall;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program: lab
 * @author: Jeffrey
 * @create: 2025-04-02 18:18
 * @description:
 **/
@Service
public class RegisterService {

    @Resource
    private UserMapper userMapper;

    public CommonResp register(UserRegisterReq req) {
        //1.判断有无重复名
        String userAccount = req.getUserAccount();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserAccountEqualTo(userAccount);
        List<User> users = userMapper.selectByExample(userExample);
        CommonResp<Object> resp = new CommonResp<>();
        //2.为用户赋值
        if (users.size() == 0){
            User copy = CopyUtil.copy(req, User.class);
            SnowFlakeSmall snowFlakeSmall = new SnowFlakeSmall();
            copy.setUserId(snowFlakeSmall.nextId());
            copy.setStatus(Byte.valueOf("1")); //1表示待审核
            Date date = new Date();
            copy.setCreateTime(date);
            copy.setUpdateTime(date);
            //3.插入数据
            userMapper.insertSelective(copy);
            //4.返回结果
            resp.setContent("注册成功");
        }else {
            //有重复名，请换名
            resp.setIsSuccess(false);
            resp.setMessage("该账户已存在，请更换！");
        }
        return resp;
    }
}
