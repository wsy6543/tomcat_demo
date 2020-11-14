package com.igengmei.serlet;

import com.igengmei.domain.User;
import com.igengmei.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 中文乱码
        req.setCharacterEncoding("UTF-8");

        // 1. 接收参数
        Integer id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("name");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        Date datebirthday = java.sql.Date.valueOf(birthday);

        // 2.封装参数
        User user = new User();
        user.setId(id);
        user.setName(username);
        user.setPassword(password);
        user.setSex(sex);
        user.setBirthday(datebirthday);


        // 3.调用方法
        try {
            new UserServiceImpl().addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 4.输出
        resp.getWriter().println("add success..");

    }
}
