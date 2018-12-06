package com.springboot.service;

import com.springboot.dao.UsersDao;
import com.springboot.pojo.Users;

public interface UsersService {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public Users login(String username, String password);
    /**
     * 判断用户是否为管理员
     * @param username
     * @return
     */
    public int isAdmin(String username);

    /**
     * 判断用户是否存在
     * @param username
     * @return
     */
    public int isexists(String username);
    /**
     * 注册
     * @param u
     * @return
     */
    public int regist(Users u);

}
