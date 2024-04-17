package com.herbalmanagement.controller;

import com.herbalmanagement.pojo.User;
import com.herbalmanagement.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    //判断登录状态
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model,
                       @RequestParam("set")Byte set){
        boolean loginSuccess = userService.login(user.getUsername(), user.getPassword());
        if (loginSuccess){
            // 把登录成功的用户保存起来
            session.setAttribute("loginUser", user.getUsername());
            // 登录成功重定向到main页面，防止表单重复提交
            return "redirect:/main";
        } else {
            // 登录失败，回到登录页面，并显示错误信息
            model.addAttribute("msg", "账号密码错误");
            if (set == 1){
                model.addAttribute("set",1);
            }
            return "forward:/reLogin";
        }
    }
    @PostMapping("/reLogin")
    public String reLogin(@RequestParam("set")Byte set){
        if (set == 1){
            return "/login";
        } else {
            return "/re_login";
        }
    }
}
