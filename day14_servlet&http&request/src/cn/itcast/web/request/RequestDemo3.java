package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/RequestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示获取请求头数据:user-agent（是哪一个浏览器）
        String agent = request.getHeader("user-agent");
        //判断浏览器的类型
        if(agent.contains("Chrome")){
            System.out.println("谷歌来了");
        }else if(agent.contains("Firefox")){
            System.out.println("火狐来了");
        }



    }
}
