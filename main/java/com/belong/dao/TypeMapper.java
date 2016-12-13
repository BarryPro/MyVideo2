package com.belong.dao;

import com.belong.model.Type;

public interface TypeMapper {
    int deleteByPrimaryKey(Integer vid);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(Integer vid);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
}