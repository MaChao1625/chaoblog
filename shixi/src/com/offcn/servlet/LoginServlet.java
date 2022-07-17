package com.offcn.servlet;

import com.offcn.util.JDBCUtils;


import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //1.接受前台传来的数据。通过前台的name值进行获取输入框中的values值

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        //2.处理数据
        Connection conn = JDBCUtils.getConn();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean  flag = false;
        try {
            String sql = "select * from user where username= ? and password = ?";
            stmt = conn.prepareStatement(sql);
            //给？赋值
            stmt.setString(1,username);
            stmt.setString(2,password);
            System.out.println(sql);
            //3.执行sql
            rs = stmt.executeQuery();
            //4.处理结果
            flag = rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            JDBCUtils.choseAll(rs,stmt,conn);
        }
        //3.给出响应
        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        if(flag){
            System.out.println("登录成功");
            pw.print("<p style='color:green;font-size:20px;'>登录成功</p>");
        }else{
            pw.print("<p style='color:red;font-size:20px;'>登录失败</p>");
            System.out.println("登录失败");
        }
    }
}
