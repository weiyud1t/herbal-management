package com.herbalmanagement.controller;

import com.herbalmanagement.service.UserInfoService;
import com.herbalmanagement.service.impl.UserServiceImpl;
import com.herbalmanagement.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserServiceImpl userService;
    //用户管理
    @GetMapping("/userManagements")
    public String userManagement(Model model){
        List<UserInfo> all = userService.findAll();
        model.addAttribute("all",all);
        return "forward:/userList";
    }
    //注册成功，添加用户信息
    @PostMapping("/addUser")
    public String addUser(@RequestParam("username")String username,
                          @RequestParam("password")String password,
                          @RequestParam("age")Integer age,
                          @RequestParam("phoneNumber")String phoneNumber,
                          @RequestParam("email")String email){
        userService.add(username,password);
        userInfoService.add(username,age,phoneNumber,email);
        return "redirect:/login";
    }
}
