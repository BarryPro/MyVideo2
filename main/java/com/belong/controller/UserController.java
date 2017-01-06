package com.belong.controller;

import com.belong.encrypt.MD5;
import com.belong.model.User;
import com.belong.service.IUserService;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;
import java.util.Properties;

/**
 * Created by belong on 2017/1/2.
 */
@Controller
@RequestMapping(value = "/my_user")
@SessionAttributes(value = "user")
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
    private static final String FILE = "visitor.txt";
    private static final String COUNT = "count";
    private static final String TMP = "tmp";
    private static final String SYSTEMSEPARATOR = "/";
    private static final String RFAILED = "对不起，注册失败了，别灰心再重新来一次吧";
    private static final String RSUCCESS = "恭喜你注册成功了，快去登陆吧";

    @Autowired
    private IUserService service;

    @RequestMapping(value = "/login")
    public String login(User user,
                        Map map,
                        @RequestParam(value="cookie",defaultValue = "off") String cookie,
                        HttpServletResponse response){
        String msg;
        String cookiePWD = user.getPassword();
        user.setPassword(MD5.getMD5(user.getPassword()));
        User cor_user = service.login(user);
        if(cor_user!=null){
            if(!cookie.equals(OFF)){
                Cookie cookie1 = new Cookie(COOKIEUSERNAME,cor_user.getUsername());
                cookie1.setMaxAge(7*24*3600);
                Cookie cookie2 = new Cookie(COOKIEPASSWORD,cookiePWD);
                cookie2.setVersion(7*24*3600);
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }
            map.put(USER,cor_user);
            msg = SUCCESS+cor_user.getUsername()+POST;
        } else {
            msg = FAILED;
        }
        map.put(MSG,msg);
        return "video/home.ftl";
    }

    @RequestMapping(value = "/logout")
    public String logout(SessionStatus sessionStatus, Map map){
        //注销当前的session
        sessionStatus.setComplete();
        map.put(MSG,LOGOUT);
        return "video/home.ftl";
    }

    @RequestMapping(value = "/visitor")
    public String getVisitor(HttpServletResponse response){
        InputStream is = UserController.class.getClassLoader().getResourceAsStream(FILE);
        Properties pro = new Properties();
        try {
            pro.load(is);
            String counter = pro.get(COUNT).toString();
            PrintWriter pw = response.getWriter();
            add();
            pw.write(counter);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "video/home.ftl";
    }

    //添加访客只有登录可以触发
    private void add(){
        InputStream is = UserController.class.getClassLoader().getResourceAsStream(FILE);
        Properties pro = new Properties();
        try {
            pro.load(is);
            String counter = pro.get(COUNT).toString();
            int sum = Integer.parseInt(counter);
            sum++;
            //得到项目目录
            String tpath = UserController.class.getClassLoader().getResource("").toString();
            String upload = tpath+FILE;
            //去掉file: 5个字符
            String stdupload = upload.substring(5,upload.length());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(stdupload)));
            String str = "count="+sum;
            bos.write(str.getBytes());
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/register")
    public String register(
                           HttpServletRequest request){
        //1.得到服务器路径
        String tpath=request.getServletContext().getRealPath(SYSTEMSEPARATOR);
        //2.定义临时文件
        File tmp = new File(TMP);
        DiskFileItemFactory dfif = new DiskFileItemFactory();
        dfif.setRepository(tmp);
        dfif.setSizeThreshold(1024*1024);
        ServletFileUpload sfu = new ServletFileUpload(dfif);
        sfu.setFileSizeMax(1024*1024);
        sfu.setSizeMax(10*1024*1024);
        try {
            FileItemIterator fii = sfu.getItemIterator(request);
            User user = service.upLoad(fii, tpath);
            String msg = null;
            if(service.register(user)){//注册成功
                msg = RSUCCESS;
            } else {//注册失败
                msg = RFAILED;
            }
            request.setAttribute(MSG,msg);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "video/home.ftl";
    }
}
