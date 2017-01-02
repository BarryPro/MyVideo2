package com.belong.controller;

import com.belong.encrypt.MD5;
import com.belong.model.User;
import com.belong.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

/**
 * Created by belong on 2017/1/2.
 */
@Controller
@RequestMapping(value="/my_user")
@SessionAttributes(value="user")
public class UserController {
    private static final String SUCCESS = "登录成功,欢迎";
    private static final String POST = "光临本站";
    private static final String FAILED = "对不起，登录失败，请注册账号或者密码和账号不一致";
    private static final String LOGOUT = "注销成功";
    private static final String MSG = "msg";
    private static final String USER = "user";
    private static final String COOKIEUSERNAME = "com.belong.username";
    private static final String COOKIEPASSWORD = "com.belong.password";
    private static final String OFF = "off";

    @Autowired
    private IUserService service;

    @RequestMapping(value = "/login")
    public String login(User user,
                        Map map,
                        @RequestParam(value="cookie",defaultValue = "off") String cookie){
        String msg;
        String cookiePWD = user.getPassword();
        user.setPassword(MD5.getMD5(user.getPassword()));
        User cor_user = service.login(user);
        if(cor_user!=null){
            if(!cookie.equals(OFF)){
                addCookie(cor_user.getUsername(),cookiePWD);
            }
            map.put(USER,cor_user);
            msg = SUCCESS+cor_user.getUsername()+POST;
        } else {
            msg = FAILED;
        }
        map.put(MSG,msg);
        return "video/home.ftl";
    }

    //添加cookie
    private void addCookie(
            @CookieValue(value = COOKIEUSERNAME,required = false) String username,
            @CookieValue(value = COOKIEPASSWORD,required = false) String password){
    }

    @RequestMapping(value="/logout")
    public String logout(SessionStatus sessionStatus, Map map){
        //注销当前的session
        sessionStatus.setComplete();
        map.put(MSG,LOGOUT);
        return "video/home.ftl";
    }
}
