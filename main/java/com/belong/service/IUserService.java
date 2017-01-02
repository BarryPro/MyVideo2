package com.belong.service;

import com.belong.model.User;
import org.apache.commons.fileupload.FileItemIterator;

/**
 * Created by belong on 16-11-5.
 */
public interface IUserService {
    boolean register(User user);
    User upLoad(FileItemIterator fii, String tpath);
    User login(User user);
    byte[] getPic(int id);
    String getAuthor(int userid);
    boolean updataSelect(int value, int userid);
}
