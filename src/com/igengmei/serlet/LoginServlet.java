package com.igengmei.serlet;

import com.igengmei.domain.User;
import com.igengmei.service.UserService;
import com.igengmei.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // 解决中文乱码
        request.setCharacterEncoding("UTF-8");
        // 获取登陆用户名
        String username = request.getParameter("username");
        // 获取登陆密码
        String password = request.getParameter("password");
        // 创建userService对象，接口接收（多态）
        UserService userService = new UserServiceImpl();
        // 调用service方法，根据前台传递用户名密码进行查询
        try {
            User user = userService.login(username, password);
            if(user != null){
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                resp.sendRedirect("success.html");
            }else {
                resp.getWriter().println("用户名密码错误");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
