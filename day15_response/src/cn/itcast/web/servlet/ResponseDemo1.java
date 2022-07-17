package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
* 重定向*/

@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo11111........");


        //1.需求
        //访问/responseDemo1,会自动跳转/responseDemo2资源
       /* //1.设置状态码给302
        response.setStatus(302);
        //2.设置响应头location
        response.setHeader("location","/day15_response/responseDemo2");*/


       //重定向不能使用request对象来共享数据，下面进行测试。先进行存储
        request.setAttribute("msg","我是测试数据");

        //动态的获取虚拟目录（然后进行拼接路径）
        String contextPath = request.getContextPath();

        //简单的重定向的方法
        response.sendRedirect(contextPath+"/responseDemo2");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
