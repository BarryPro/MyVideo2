package com.belong.dao;

import com.belong.model.Movies;
import com.belong.model.MoviesExample;
import com.belong.model.MoviesWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MoviesMapper {
    int countByExample(MoviesExample example);

    int deleteByExample(MoviesExample example);

    int deleteByPrimaryKey(Integer vid);

    int insert(MoviesWithBLOBs record);

    int insertSelective(MoviesWithBLOBs record);

    List<MoviesWithBLOBs> selectByExampleWithBLOBs(MoviesExample example);

    List<Movies> selectByExample(MoviesExample example);

    MoviesWithBLOBs selectByPrimaryKey(Integer vid);

    int updateByExampleSelective(@Param("record") MoviesWithBLOBs record, @Param("example") MoviesExample example);

    int updateByExampleWithBLOBs(@Param("record") MoviesWithBLOBs record, @Param("example") MoviesExample example);

    int updateByExample(@Param("record") Movies record, @Param("example") MoviesExample example);

    int updateByPrimaryKeySelective(MoviesWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MoviesWithBLOBs record);

    int updateByPrimaryKey(Movies record);
}