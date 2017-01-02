package com.belong.controller;

import com.belong.model.User;
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
    @RequestMapping(value = "/login")
    public String login(User user){
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "video/home.ftl";
    }
}
