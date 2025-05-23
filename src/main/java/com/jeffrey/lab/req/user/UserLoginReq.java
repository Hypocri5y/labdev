package com.jeffrey.lab.req.user;

import javax.validation.constraints.NotEmpty;

/**
 * @program: lab
 * @author: Jeffrey
 * @create: 2025-04-02 17:20
 * @description:
 **/
public class UserLoginReq {
    @NotEmpty(message = "【用户名】不能为空")
    private String loginName;
    @NotEmpty(message = "【密码】不能为空")
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", loginName=").append(loginName);
        sb.append(", password=").append(password);
        sb.append("]");
        return sb.toString();
    }
}