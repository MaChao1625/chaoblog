package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
/*dispatcherTypes属性：
* 1.request:默认值，浏览器直接请求资源
* 2.forward:转发访问资源
* 3.include:包含访问资源
* 4.error：错误跳转资源
* 5.async：异步访问资源*/

//浏览器直接访问资源时，该过滤器会被执行
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.REQUEST)

//只有转发访问index.jsp时，过滤器才会被访问
//@WebFilter(value = "/index.jsp",dispatcherTypes =DispatcherType.FORWARD)

//多种请求方式，执行过滤器(浏览器直接请求index.jsp或者请求转发index.jsp,该过滤器才会被执行)
//@WebFilter(value = "/index.jsp",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class FilterDemo5 implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo5 ....");
        //放行
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {


    }

    public void destroy() {

    }


}
