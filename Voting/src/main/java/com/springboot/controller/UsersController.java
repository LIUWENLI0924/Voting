package com.springboot.controller;


import com.springboot.pojo.Users;

import com.springboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
/ **
* 
    user
* /
@Controller
public class UsersController {
    @Autowired
    private UserServiceImpl us;

    /**
     * 登录
     * @param model
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public String login(Model model, HttpSession session, String username, String password){
        System.out.println("登录");
        Users u=us.login(username,password);
        if(u!=null){
            session.setAttribute("users",u);
            return "forward:/getVote?pageIndex=1";
        }else {
            model.addAttribute("message","用户名或密码错误！");
            return "login";
        }
    }


    /**
     * 注册
     * @param u
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public int register(Users u){
        System.out.println("注册");
        int num=us.regist(u);
        return num;
    }


    @RequestMapping(value = "/isexists",method = RequestMethod.POST)
    @ResponseBody
    public int isexists(String username){
        int num=us.isexists(username);
        return num;
    }
}
