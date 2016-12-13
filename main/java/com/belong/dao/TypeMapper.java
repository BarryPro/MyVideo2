package com.belong.dao;

import com.belong.model.Type;
import com.belong.model.TypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypeMapper {
    int countByExample(TypeExample example);

    int deleteByExample(TypeExample example);

    int deleteByPrimaryKey(Integer vid);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(Integer vid);

    int updateByExampleSelective(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByExample(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
}