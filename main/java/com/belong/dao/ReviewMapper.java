package com.belong.dao;

import com.belong.model.Review;
import com.belong.model.ReviewWithBLOBs;

public interface ReviewMapper {
    int deleteByPrimaryKey(Integer vid);

    int insert(ReviewWithBLOBs record);

    int insertSelective(ReviewWithBLOBs record);

    ReviewWithBLOBs selectByPrimaryKey(Integer vid);

    int updateByPrimaryKeySelective(ReviewWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ReviewWithBLOBs record);

    int updateByPrimaryKey(Review record);
}