package com.herbalmanagement.service;

import com.herbalmanagement.pojo.UserAllinfo;
import com.herbalmanagement.pojo.UserInfo;

import java.util.List;

public interface UserService {
    List<UserInfo> findAll();
    void add(String username,String password);
    boolean login(String username, String password);
    UserAllinfo findUserByUsername(String username);
    void updateUser(UserAllinfo user);
}
