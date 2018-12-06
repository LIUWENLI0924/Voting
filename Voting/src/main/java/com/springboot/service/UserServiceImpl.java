package com.springboot.service;

import com.springboot.dao.UsersDao;
import com.springboot.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UsersService{
    @Autowired
    private UsersDao ud;

    @Override
    public Users login(String username, String password) {
        return ud.login(username,password);
    }

    @Override
    public int isAdmin(String username) {
        return ud.isAdmin(username);
    }

    @Override
    public int isexists(String username) {
        return ud.isexists(username);
    }

    @Override
    public int regist(Users u) {
        return ud.regist(u);
    }
}
