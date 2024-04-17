package com.herbalmanagement.service.impl;

import com.herbalmanagement.mapper.UserInfoMapper;
import com.herbalmanagement.pojo.UserInfo;
import com.herbalmanagement.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper mapper;

    @Override
    public UserInfo searchByName(String name) {
        return  mapper.selectByUsername(name);
    }

    @Override
    public void add(String username,Integer age,String phoneNumber,String email) {
        UserInfo userInfo = new UserInfo(null,username,age,email,phoneNumber);
        mapper.insert(userInfo);
    }
}
