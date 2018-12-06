package com.springboot.dao;

import com.springboot.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Autowired
    public Users login(@Param("username")String username, @Param("password") String password);

    /**
     * 判断用户是否为管理员
     * @param username
     * @return
     */
    @Autowired
    public int isAdmin(String username);

    /**
     * 注册
     * @param u
     * @return
     */
    @Autowired
    public int regist(Users u);

    /**
     * 判断用户是否存在
     * @param username
     * @return
     */
    @Autowired
    public int isexists(String username);
}
