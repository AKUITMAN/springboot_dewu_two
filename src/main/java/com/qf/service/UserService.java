package com.qf.service;

import com.qf.commom.BaseResponse;
import com.qf.pojo.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    String sendMail(String mail, HttpServletRequest request);

    BaseResponse login(User user, HttpServletRequest request);

    BaseResponse registry(User user,HttpServletRequest request);
}
