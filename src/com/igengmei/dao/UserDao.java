package com.igengmei.dao;

import com.igengmei.domain.User;

import java.sql.SQLException;

public interface UserDao {

    /*
        用户登陆
     */
    public User login(String username,String password) throws SQLException;

    /*
        用户添加
     */
    public void addUser(User user) throws SQLException;



}