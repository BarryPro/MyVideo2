package com.belong.controller;

import com.belong.model.Article;
import com.belong.model.PageBean;
import com.belong.model.Review;
import com.belong.service.IArticleService;
import com.belong.service.IMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by belong on 2017/1/10.
 */
@Controller
@RequestMapping(value = "/my_review")
public class ArticleController {
    private static final String COMMENT = "video/comment.ftl";
    private static final String A_VID = "a_Vid";
    private static final String UID = "Uid";
    private static final String ROOTID = "rootid";
    private static final String USERID = "userid";
    private static final String VID = "Vid";
    private static final String CURPAGE = "cur_page";
    private static final String ENCODER = "utf-8";

    @Autowired
    private IMoviesService service;

    @Autowired
    private IArticleService aservice;

    @Autowired
    private VideoController videoController;

    @RequestMapping(value = "/review/Vid/{vid}")
    public String review(@PathVariable(value = "vid") int vid,
                         Map map) {
        map.put("vid", vid);
        Review review = service.review(map);
        map.put("review", review);
        return COMMENT;
    }

    @RequestMapping(value = "/query")
    public String query(@RequestParam(CURPAGE) int cur_page,
                        @RequestParam(VID) int vid,
                        @RequestParam(USERID) int userid,
                        Map map,
                        HttpServletResponse response){
        map.put(CURPAGE,cur_page);
        map.put(A_VID,vid);
        map.put(UID,userid);
        ArrayList<Article> data = aservice.queryArticle(map);
        PageBean pageBean = new PageBean();
        pageBean.setArticles(data);
        pageBean.setRow_num((int) map.get("a_pagenum"));
        pageBean.setRow_total((int) map.get("row_total"));
        pageBean.setPage_total((int) map.get("page_total"));
        pageBean.setCur_page((int) map.get("cur_page"));
        response.setCharacterEncoding(ENCODER);
        videoController.json(pageBean,response);
        return COMMENT;
    }

    @RequestMapping(value = "/add_article")
    public String addArticle(Article article,
                             Map map){
        map.put("article",article);
        aservice.addArticle(map);
        return COMMENT;
    }

}
