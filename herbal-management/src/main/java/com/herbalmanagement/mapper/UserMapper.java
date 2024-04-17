package com.herbalmanagement.mapper;

import com.herbalmanagement.pojo.User;
import com.herbalmanagement.pojo.UserAllinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    int insert(User row);
    @Select("SELECT COUNT(*) FROM users WHERE username = #{username} AND password = #{password}")
    int countByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Select("SELECT users.username, users.password, user_info.age, user_info.email, user_info.phone_number\n" +
            "FROM users\n" +
            "INNER JOIN user_info ON users.username = user_info.username\n" +
            "WHERE users.username = #{username}")
    UserAllinfo findUserByUsername(@Param("username") String username);

    @Update("UPDATE users SET password = #{user.password} WHERE username = #{user.username}")
    void updateUserPassword(@Param("user") UserAllinfo user);

    @Update("UPDATE user_info SET age = #{user.age}, email = #{user.email}, phone_number = #{user.phoneNumber} WHERE username = #{user.username}")
    void updateUserInfo(@Param("user") UserAllinfo user);
}