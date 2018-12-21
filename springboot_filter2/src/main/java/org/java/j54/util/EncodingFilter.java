package org.java.j54.util;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import java.io.IOException;

public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("===!!!!!!@@@@@@@@@@@@==========进入过滤器");
        filterChain.doFilter(servletRequest,servletResponse );
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
