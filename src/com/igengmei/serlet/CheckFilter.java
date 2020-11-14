package com.igengmei.serlet;

import com.igengmei.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class CheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 类型向下转型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        // 判断session中是否有user信息，判断是否是登陆状态
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user != null) {
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            response.getWriter().println("请先登陆");
        }
    }

    @Override
    public void destroy() {

    }
}