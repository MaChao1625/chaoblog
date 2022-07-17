package com.offcn.servlet;

import com.offcn.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //0.处理中文乱码的请求，只针对post请求
        req.setCharacterEncoding("utf-8");
        //1.接受前端的数据
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        //2.处理数据 调用dao层
        StudentDao sd = new StudentDao();
        int num = sd.addStudent(name,age,gender,email,phone);
        //3.给出响应
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        if(num>0){
            pw.print("请求成功");
        }else{
            pw.print("请求失败");
        }

    }
}
