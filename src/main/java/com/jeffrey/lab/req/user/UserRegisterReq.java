package com.jeffrey.lab.req.user;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @program: lab
 * @author: Jeffrey
 * @create: 2025-04-02 18:11
 * @description:
 **/
public class UserRegisterReq {

    @NotEmpty(message = "【账户】不能为空")
    private String userAccount;
    @NotEmpty(message = "【密码】不能为空")
    private String userPwd;
    @NotEmpty(message = "【用户名】不能为空")
    private String userName;

    private String phone;

    private String email;

    @NotEmpty(message = "【权限】不能为空")
    private String role;


    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userAccount=").append(userAccount);
        sb.append(", userPwd=").append(userPwd);
        sb.append(", userName=").append(userName);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", role=").append(role);
        sb.append("]");
        return sb.toString();
    }
}
