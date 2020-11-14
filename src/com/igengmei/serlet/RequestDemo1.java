package com.igengmei.serlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String pw = req.getParameter("password");
        System.out.println(pw);
        System.out.println(username);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        Map<String, String[]> parameterMap = req.getParameterMap();
        parameterMap.forEach((k,v)->{
            System.out.println(k + "=" + Arrays.toString(v));
        });


    }
}
