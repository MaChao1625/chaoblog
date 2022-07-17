package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet( "/RequestDemo6")
public class RequestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post获取请求方式
        String username = request.getParameter("username");
        /*System.out.println("post");
        System.out.println(username);*/
        //根据参数名称获取参数值
        String[] hobbies = request.getParameterValues("hobby");
        /*for(String hobby : hobbies){
            System.out.println(hobby);
        }*/
        //获取所有请求的参数名称
        Enumeration<String> parameterNames = request.getParameterNames();
        /*while(parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = request.getParameter(name);
            System.out.println(value);
            System.out.println("------------");

        }*/
        System.out.println("-------------------------");
        //获取所有参数的map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        //遍历
        Set<String> keyset = parameterMap.keySet();
        for(String name:keyset){
            //获取键获取值
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for(String value:values){
                System.out.println(value);
            }
            System.out.println("-------------");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get获取请求方式
        /*String username = request.getParameter("username");
        System.out.println("get");
        System.out.println(username);*/
        this.doPost(request,response);
    }
}
