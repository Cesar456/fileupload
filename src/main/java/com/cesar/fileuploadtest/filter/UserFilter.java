package com.cesar.fileuploadtest.filter;


import com.cesar.fileuploadtest.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Cesar on 2016/11/10.
 * 检查当前是否登录，当请求不允许未登录用户时，挂掉
 */
public class UserFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user == null) {
            res.sendRedirect("http://" + req.getHeader("Host") + "/user/login");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
