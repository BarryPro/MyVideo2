package com.belong.dao;

import com.belong.model.Movies;
import com.belong.model.Review;

public interface MoviesMapper {
    boolean upload(Review review);
    String getPath(int Vid);
    Movies getPic(int Vid);
    void views(int Vid);
    Review review(int Vid);
}
