package com.belong.controller;

import com.alibaba.fastjson.JSON;
import com.belong.model.Movies;
import com.belong.model.PageBean;
import com.belong.service.IMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by belong on 2017/1/1.
 */
@Controller
@RequestMapping(value = "/my_video")
@SessionAttributes(value = "video")
public class VideoController {
    private static final String USERID = "userid";
    private static final String CUR_PAGE = "cur_page";
    private static final String ENCODER = "utf-8";
    private static final String N = "n";
    private static final String IMAGE = "image/jpeg";

    @Autowired
    private IMoviesService service;

    //得到主页
    @RequestMapping(value = "/home")
    public String main(){
        return "video/home.ftl";
    }

    @RequestMapping(value = "/db_info")
    public String getDB_info(@RequestParam(N) String n,
                             @RequestParam(CUR_PAGE) String cur_page,
                             @RequestParam(USERID) String userid,
                             HttpServletResponse response){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("Vtype",Integer.parseInt(n));
        map.put("cur_page",Integer.parseInt(cur_page));
        map.put("Uid",Integer.parseInt(userid));
        ArrayList<Movies> data = service.getInfo(map);
        PageBean pageBean = new PageBean();
        pageBean.setData(data);
        pageBean.setRow_num(map.get("row_num"));
        pageBean.setRow_total(map.get("row_total"));
        pageBean.setPage_total(map.get("page_total"));
        response.setCharacterEncoding(ENCODER);
        try {
            String json = JSON.toJSONString(pageBean);
            PrintWriter pw = response.getWriter();
            pw.write(json);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "video/home.ftl";
    }

    @RequestMapping(value = "/pic/Vid/{vid}")
    public String getPic(@PathVariable(value = "vid") int vid,HttpServletResponse response){

        response.setContentType(IMAGE);
        try {
            Movies movies = service.getPic(vid);
            byte[] buffer = movies.getVpic();
            ServletOutputStream sos = response.getOutputStream();
            sos.write(buffer);
            sos.flush();
            sos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "video/home.ftl";
    }
}
