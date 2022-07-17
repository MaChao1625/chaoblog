package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/user/findAllServlet")
public class FilterDemo4 implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo4 ....");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {


    }

    public void destroy() {

    }


}
