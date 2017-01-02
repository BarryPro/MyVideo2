package com.belong.controller;

import com.belong.model.User;
import com.belong.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by belong on 2017/1/2.
 */
@Controller
@RequestMapping(value = "/my_user")
@SessionAttributes(value = "user")
public class UserController {

    @Autowired
    private IUserService service;

    @RequestMapping(value = "/login")
    public String login(User user){
        User cor_user = service.login(user);
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println(cor_user.getUsername());
        return "video/home.ftl";
    }
}
