package com.herbalmanagement.service;

import com.herbalmanagement.pojo.UserInfo;

public interface UserInfoService {
    UserInfo searchByName(String name);
    void add(String username,Integer age,String phoneNumber,String email);
}
