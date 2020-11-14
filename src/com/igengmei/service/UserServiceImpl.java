package com.igengmei.service;

import com.igengmei.dao.UserDao;
import com.igengmei.dao.UserDaoImpl;
import com.igengmei.domain.User;

import java.sql.SQLException;


public class UserServiceImpl implements UserService {

    /*
        根据用户密码查询用户信息
     */
    @Override
    public User login(String username, String password) throws SQLException {

        UserDao userDao = new UserDaoImpl();
        User user = userDao.login(username, password);
        return user;
    }

    @Override
    public void addUser(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        userDao.addUser(user);
    }
}
