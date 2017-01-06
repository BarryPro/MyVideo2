package com.belong.service;

import com.belong.model.Movies;
import com.belong.model.PageBean;
import com.belong.model.Review;
import org.apache.commons.fileupload.FileItemIterator;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by belong on 16-11-6.
 */
public interface IMoviesService {
    Review uploadFile(FileItemIterator fii, String tpath);
    String getPath(int Vid);
    boolean upload(Review review);
    Movies getPic(int Vid);
    PageBean search(String txt, int cur_page, int userid);
    boolean views(int Vid);
    Review review(int Vid);
    ArrayList<Movies> getInfo(Map map);
}
