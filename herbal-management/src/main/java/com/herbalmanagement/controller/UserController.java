package com.herbalmanagement.controller;

import com.herbalmanagement.service.UserInfoService;
import com.herbalmanagement.service.UserService;
import com.herbalmanagement.pojo.UserAllinfo;
import com.herbalmanagement.pojo.UserInfo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserInfoService service;
    @Autowired
    private UserService userService;
    //个人信息
    @GetMapping("/personalMassage")
    public String personalMassage(HttpSession session, Model model){
        String name = (String)session.getAttribute("loginUser");
        UserInfo userInfo = service.searchByName(name);
        model.addAttribute("user",userInfo);
        return "forward:/aUser";
    }
    // 显示用户信息页面
    @GetMapping("/showUser")
    public String showUser(@RequestParam("username") String username, Model model) {
        UserAllinfo user = userService.findUserByUsername(username);
        model.addAttribute("user", user);
        return "forward:/aUser";
    }

    // 显示编辑用户信息页面
    @GetMapping("/editUser")
    public String editUser(String username, Model model) {
        UserAllinfo userInfo = userService.findUserByUsername(username);
        model.addAttribute("user", userInfo);
        return "forward:/eUser";
    }

    // 处理编辑用户信息的表单提交
    @PostMapping("/editUser")
    public String updateUser(UserAllinfo user) {
        userService.updateUser(user);
        return "redirect:/showUser?username=" + user.getUsername();
    }
}
