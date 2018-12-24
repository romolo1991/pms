package com.test.ssh.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VerifyLoginFilter implements Filter {

    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----Filter初始化----");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 对request、response进行一些预处理
        request = (HttpServletRequest) servletRequest;
        response = (HttpServletResponse) servletResponse;

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取url
        String requestUrl = request.getRequestURL().toString();
        if (requestUrl == null || requestUrl.trim().length() == 0)
            return;
        if (requestUrl.contains("login.jsp")) {
            //放行user.action
            filterChain.doFilter(request, response);
            System.out.println("----请求登录界面，放行:" + requestUrl);
        } else {
            if (request.getSession().getAttribute("user") != null) {
                filterChain.doFilter(request, response); // 执行目标资源，放行
                System.out.println("----用户已登录，放行:" + requestUrl);
            } else {
                response.sendRedirect("/login.jsp");
                System.out.println("----用户未登录，拦截:" + requestUrl);
            }
        }

    }

    @Override
    public void destroy() {
        System.out.println("----Filter销毁----");
    }
}
