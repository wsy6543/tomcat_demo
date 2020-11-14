package com.igengmei.serlet;

import javax.servlet.*;
import java.io.IOException;

public class QuickFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("jfksajkk 拦截陈宫");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("拦截了显影");
    }

    @Override
    public void destroy() {

    }
}
