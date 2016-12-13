package com.belong.dao;

import com.belong.model.Movies;
import com.belong.model.MoviesWithBLOBs;

public interface MoviesMapper {
    int deleteByPrimaryKey(Integer vid);

    int insert(MoviesWithBLOBs record);

    int insertSelective(MoviesWithBLOBs record);

    MoviesWithBLOBs selectByPrimaryKey(Integer vid);

    int updateByPrimaryKeySelective(MoviesWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MoviesWithBLOBs record);

    int updateByPrimaryKey(Movies record);
}