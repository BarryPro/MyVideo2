package com.belong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by belong on 2017/1/1.
 */
@Controller
@RequestMapping(value = "/my_video")
@SessionAttributes(value = "video")
public class VideoController {
    //得到主页
    @RequestMapping(value = "/home")
    public String main(){
        return "video/home.ftl";
    }
}
