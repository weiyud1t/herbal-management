package com.herbalmanagement.service.impl;

import com.herbalmanagement.mapper.UserInfoMapper;
import com.herbalmanagement.mapper.UserMapper;
import com.herbalmanagement.pojo.User;
import com.herbalmanagement.pojo.UserAllinfo;
import com.herbalmanagement.pojo.UserInfo;
import com.herbalmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    //这里使用自动注入，要把mapper包中的所有类加上@Mapper注解
    @Autowired
    private UserInfoMapper mapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> list = mapper.selectByExample(null);
        return list;
    }

    @Override
    public void add(String username,String password) {
        User user = new User(username,password);
        userMapper.insert(user);
    }

    @Override
    public boolean login(String username, String password) {
        // 使用新的mapper方法来检查用户名和密码
        int count = userMapper.countByUsernameAndPassword(username, password);
        return count > 0;
    }
    public UserAllinfo findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    public void updateUser(UserAllinfo user) {
        userMapper.updateUserPassword(user);
        userMapper.updateUserInfo(user);
    }
}
