package com.qf.service.impl;

import com.qf.commom.BaseResponse;
import com.qf.dao.UserMapper;
import com.qf.dao.UserRespository;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;
@Service
public class UserServiceImpl implements UserService {
    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    UserRespository userRespository;

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;


    @Override
    public String sendMail(String mail, HttpServletRequest request) {
        if (mail!=null){
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(from);
            simpleMailMessage.setTo(mail);
            simpleMailMessage.setSubject("得物验证码");
            Random random = new Random();
            StringBuffer code = new StringBuffer();
            for (int i =0;i<4;i++){
                int i1 = random.nextInt(10);
                code.append(i1);
            }
            simpleMailMessage.setText(code.toString());
            javaMailSender.send(simpleMailMessage);
            //存储到session中
            HttpSession session = request.getSession();
            session.setAttribute(mail,code.toString());
            return "success";
        }

        return "fail";
    }

    @Override
    public BaseResponse login(User user, HttpServletRequest request) {
        User user1=userRespository.findByEmail(user.getEmail());
        BaseResponse baseResponse = new BaseResponse();
        if (user1!=null){
            HttpSession session1=request.getSession();
            String text= (String) session1.getAttribute(user.getEmail());
            if (user.getCode().equals(text)){
                userMapper.update(text,user1.getId());
                //登陆成功，将信息存储到session中
                HttpSession session=request.getSession();
                session.setAttribute(user.getEmail(),user);
                baseResponse.setCode(200);
                baseResponse.setMessage("登录 成功！");
                baseResponse.setData(user);
                return baseResponse;
            }else{
                baseResponse.setCode(202);
                baseResponse.setMessage("验证码错误！");
                return baseResponse;
            }

        }else {
           userService.registry(user, request);
           return baseResponse;
        }
    }

    @Override
    public BaseResponse registry(User user, HttpServletRequest request) {
        Integer res=userMapper.registry(user);
        BaseResponse baseResponse = new BaseResponse();

        if (res==1){
           baseResponse.setCode(200);
           baseResponse.setMessage("登陆成功");
           baseResponse.setData(user);
           return baseResponse;
        }else {
            baseResponse.setCode(201);
            baseResponse.setMessage("登陆失败");
            return baseResponse;
        }
    }
}
