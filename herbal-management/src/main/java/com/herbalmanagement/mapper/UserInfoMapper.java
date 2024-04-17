package com.herbalmanagement.mapper;

import com.herbalmanagement.pojo.UserInfo;
import com.herbalmanagement.pojo.UserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {
    int insert(UserInfo row);
    List<UserInfo> selectByExample(UserInfoExample example);
    @Select("select * from user_info where username = #{name}")
    UserInfo selectByUsername(String name);
}