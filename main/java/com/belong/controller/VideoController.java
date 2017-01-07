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

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;


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
    private static final String HOME = "video/home.ftl";
    private static final String PLAYER = "video/player.ftl";
    private static final String SRCPATH = "srcpath";
    private static final String TXT = "txt";

    private HashMap<String,String> types = new HashMap<String,String>();

    public VideoController(){
        types.put("video/avi", ".avi");
        types.put("video/mp4", ".mp4");
    }

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
        pageBean.setCur_page(map.get("cur_page"));
        response.setCharacterEncoding(ENCODER);
        json(pageBean,response);
        return HOME;
    }

    @RequestMapping(value = "/pic/Vid/{vid}")
    public String getPic(@PathVariable(value = "vid") int vid,HttpServletResponse response){
        response.setContentType(IMAGE);
        OutputStream os = null;
        try {
            Movies movies = service.getPic(vid);
            byte[] buffer = movies.getVpic();
            os = response.getOutputStream();
            os.write(buffer);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/src/Vid/{vid}")
    public String getPath(@PathVariable(value = "vid") int vid,
                          Map map){
        service.views(vid);
        String srcpath = service.getPath(vid);
        map.put(SRCPATH,srcpath);
        return PLAYER;
    }

    @RequestMapping(value = "/search")
    public String search(@RequestParam(TXT) String txt,
                         @RequestParam(CUR_PAGE) int cur_page,
                         @RequestParam(USERID) int userid,
                         HttpServletResponse response){
        Map<String,Object> map = new HashMap();
        //模糊查询
        txt = "%"+txt+"%";
        map.put("txt",txt);
        map.put("cur_page",cur_page);
        map.put("Uid",userid);
        ArrayList<Movies> data = service.search(map);
        PageBean pageBean = new PageBean();
        pageBean.setData(data);
        pageBean.setRow_num((int) map.get("row_num"));
        pageBean.setRow_total((int) map.get("row_total"));
        pageBean.setPage_total((int) map.get("page_total"));
        pageBean.setCur_page((int) map.get("cur_page"));
        response.setCharacterEncoding(ENCODER);
        json(pageBean,response);
        return HOME;
    }

    //json返回网页信息
    private void json(PageBean pageBean,HttpServletResponse response){
        try {
            String json = JSON.toJSONString(pageBean);
            PrintWriter writer = response.getWriter();
            writer.write(json);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
