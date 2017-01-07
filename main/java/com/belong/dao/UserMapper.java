package com.belong.dao;

import com.belong.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User login(@Param("user") User user);
    boolean register(@Param("user") User user);
    User getPic(int id);
}
