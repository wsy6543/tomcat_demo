package com.igengmei.service;

import com.igengmei.domain.User;

import java.sql.SQLException;

public interface UserService {

    /*
        根据用户名密码进行查询用户信息
     */
    public User login(String username, String password) throws SQLException;

    /*
        用户添加
     */
    public void addUser(User user) throws SQLException;
}