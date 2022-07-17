package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示获取请求头数据:referer(告诉浏览器，请求从哪里来)
        String referer = request.getHeader("referer");
        System.out.println(referer);
        //防盗链操作
        if(referer!=null){
            if (referer.contains("day14")){//看是不是包括/day14
                System.out.println("播放电影。。。。");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放电影");
            }else{
                System.out.println("想看电影嘛来优酷吧");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("想看电影嘛来优酷吧");
            }
        }



    }
}
