package com.belong.dao;

import com.belong.model.Movies;
import com.belong.model.PageBean;
import com.belong.model.Review;

public interface MoviesMapper {
    boolean upload(Review review);
    String getPath(int Vid);
    Movies getPic(int Vid);
    PageBean search(String txt,int cur_page,int userid);
    boolean views(int Vid);
    Review review(int Vid);
}
