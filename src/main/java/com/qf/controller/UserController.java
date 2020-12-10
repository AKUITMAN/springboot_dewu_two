package com.qf.controller;

import com.qf.commom.BaseResponse;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/sendMail",method = RequestMethod.GET)
    public String sendMail(@RequestParam("mail")String mail, HttpServletRequest request){

        return userService.sendMail(mail,request);
    }
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseResponse login(@RequestBody User user, HttpServletRequest request){

        return userService.login(user,request);
    }
}
