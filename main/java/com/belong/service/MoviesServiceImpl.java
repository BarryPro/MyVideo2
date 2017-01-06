package com.belong.service;

import com.belong.dao.MoviesMapper;
import com.belong.dao.PageMapper;
import com.belong.model.Movies;
import com.belong.model.PageBean;
import com.belong.model.Review;
import org.apache.commons.fileupload.FileItemIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by belong on 16-11-6.
 */
@Service
public class MoviesServiceImpl implements IMoviesService{
    private HashMap<String, String> types = new HashMap<String, String>();
    private HashMap<String, String> types1 = new HashMap<String, String>();
    private static final String UPLOAD = "upload";
    private static final String MOVIES = "movies";
    private static final String VINFO = "vinfo";
    private static final String VNAME = "vname";
    private static final String ENCODER = "utf-8";
    private static final String USERID = "userid";
    private static final String TYPE = "type";
    private static final String VDIRECTOR = "vdirector";
    private static final String VACTOR = "vactor";

    @Autowired
    private MoviesMapper dao;

    @Autowired
    private PageMapper prodao;

    public MoviesServiceImpl() {
        types.put("video/x-msvideo", ".avi");
        types.put("video/mp4", ".mp4");
        types1.put("image/jpeg", ".jpg");
        types1.put("image/png", ".png");
        types1.put("image/gif", ".gif");
        types1.put("image/x-ms-bmp", ".bmp");
    }

    @Override
    public Review uploadFile(FileItemIterator fii, String tpath) {
        return null;
    }

    @Override
    public String getPath(int Vid) {
        return dao.getPath(Vid);
    }


    @Override
    public boolean upload(Review review) {
        return dao.upload(review);
    }

    @Override
    public Movies getPic(int Vid) {
        return dao.getPic(Vid);
    }

    @Override
    public PageBean search(String txt,int cur_page,int userid) {
        return dao.search(txt,cur_page,userid);
    }

    @Override
    public boolean views(int Vid) {
        return dao.views(Vid);
    }

    @Override
    public Review review(int Vid) {
        return dao.review(Vid);
    }

    @Override
    public ArrayList<Movies> getInfo(Map map) {
        return prodao.getInfo(map);
    }

}


