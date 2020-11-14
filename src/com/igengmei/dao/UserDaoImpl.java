package com.igengmei.dao;

import com.igengmei.domain.User;
import com.igengmei.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    /*
        用户登陆方法
     */
    @Override
    public User login(String username, String password) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from user where username = ? and password = ?";
        Object[] param = {username,password};
        User user = queryRunner.query(sql, new BeanHandler<>(User.class), param);
        return user;
    }

    /*
        用户添加方法
     */
    @Override
    public void addUser(User user) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "insert into user(id,username,password,birthday,sex) values(?,?,?,?,?)";
        Object[] param = {null,user.getName(),user.getPassword(),user.getBirthday(),user.getSex()};
        queryRunner.update(sql, param);
    }
}