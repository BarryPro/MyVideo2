package com.belong.service;

import com.belong.dao.UserMapper;
import com.belong.model.User;
import org.apache.commons.fileupload.FileItemIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by belong on 2017/1/2.
 */
@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserMapper dao;

    @Override
    public boolean register(User user) {
        return false;
    }

    @Override
    public User upLoad(FileItemIterator fii, String tpath) {
        return null;
    }

    @Override
    public User login(User user) {
        //用于返回正确的用户信息
        return dao.login(user);
    }

    @Override
    public byte[] getPic(int id) {
        return new byte[0];
    }

    @Override
    public String getAuthor(int userid) {
        return null;
    }

    @Override
    public boolean updataSelect(int value, int userid) {
        return false;
    }
}
