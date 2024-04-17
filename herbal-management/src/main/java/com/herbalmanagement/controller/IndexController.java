package com.herbalmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    //登录
    @GetMapping({"/login","/"})
    public String login(){
        return "login";
    }
    //注册
    @GetMapping("/logon")
    public String logon(){
        return "logon";
    }
    //主页
    @GetMapping("/main")
    public String mainPage(){
        return "index";
    }
    //增改
    @GetMapping("/edit")
    public String edit(){
        return "table/edit_herb";
    }
    //查询
    @GetMapping("/herbList")
    public String showHerbList(){
        return "table/herblist";
    }
    //用户信息
    @GetMapping("/aUser")
    public String showAUser(){
        return "table/user_info";
    }
    //用户管理
    @GetMapping("/userList")
    public String showUserList(){
        return "table/user_manage";
    }
    @GetMapping("/eUser")
    public String editUser(){
        return "table/edit_User";
    }
}
