package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* cookied的快速入门*/
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的消息体的数据格式以及编码
        response.setContentType("text/html;charset=utf-8");

        //1.获取所有的cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;//设置cookie为lastTime
        //2.遍历数组
        if(cookies!=null&&cookies.length>0){
            for (Cookie cookie : cookies) {
                //3.获取cookie的名称
                String name = cookie.getName();
                //4.判断名称是不是lastTime
                if("lastTime".equals(name)){
                    flag=true;//有lastTime的cookie
                    //有该cookie，不是第一次访问
                    //设置cookie的value，也就是时间
                    //获取当前时间的字符串，重新设置cookie的值并且重新发送cookie
                    Date date = new Date();
                    //设置一下时间的格式，将美国的时间设置为中国的时间格式
                    SimpleDateFormat sdf = new SimpleDateFormat("yyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    System.out.println("编码前"+str_date);
                    //url编码
                    str_date=URLEncoder.encode(str_date,"utf-8");
                    System.out.println("编码后"+str_date);
                    cookie.setValue(str_date);
                    //设置cookie的存活时间
                    cookie.setMaxAge(60*60*24*365);
                    //重新发送cookie
                    response.addCookie(cookie);


                    //响应数据
                    //获取cookie的value，时间
                    String value = cookie.getValue();
                    System.out.println("解码前"+value);
                    //URL解码
                    value= URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后"+value);
                    response.getWriter().write("<h1>欢迎回来，你上次访问的时间为："+value+"</h1>");
                    break;

                }



            }


        }
        if (cookies==null||cookies.length==0||flag==false){
            //没有cookie名字为lastTime，第一次访问
            //设置cookie的value，也就是时间
            //获取当前时间的字符串，重新设置cookie的值并且重新发送cookie
            Date date = new Date();
            //设置一下时间的格式，将美国的时间设置为中国的时间格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyy年mm月dd日 HH:mm:ss");
            String str_date = sdf.format(date);

            System.out.println("编码前"+str_date);
            //url编码
            str_date=URLEncoder.encode(str_date,"utf-8");
            System.out.println("编码后"+str_date);
            Cookie cookie = new Cookie("lastTime",str_date);

            //设置cookie的存活时间
            cookie.setMaxAge(60*60*24*365);
            //重新发送cookie
            response.addCookie(cookie);
            response.getWriter().write("<h1>你好，欢迎你首次登陆。</h1>");


        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
