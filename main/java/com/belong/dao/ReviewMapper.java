package com.belong.dao;

import com.belong.model.Review;
import com.belong.model.ReviewExample;
import com.belong.model.ReviewWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReviewMapper {
    int countByExample(ReviewExample example);

    int deleteByExample(ReviewExample example);

    int deleteByPrimaryKey(Integer vid);

    int insert(ReviewWithBLOBs record);

    int insertSelective(ReviewWithBLOBs record);

    List<ReviewWithBLOBs> selectByExampleWithBLOBs(ReviewExample example);

    List<Review> selectByExample(ReviewExample example);

    ReviewWithBLOBs selectByPrimaryKey(Integer vid);

    int updateByExampleSelective(@Param("record") ReviewWithBLOBs record, @Param("example") ReviewExample example);

    int updateByExampleWithBLOBs(@Param("record") ReviewWithBLOBs record, @Param("example") ReviewExample example);

    int updateByExample(@Param("record") Review record, @Param("example") ReviewExample example);

    int updateByPrimaryKeySelective(ReviewWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ReviewWithBLOBs record);

    int updateByPrimaryKey(Review record);
}