package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/calculateServlet")
public class calculateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取数据
        //2.1根据参数名称获取第一个参数值。把字符串转化为double类型的数字
        double value1 =Double.parseDouble(request.getParameter("value1"));
        //2.2根据参数名称获取符号的值
        String operate = request.getParameter("operate");
        System.out.println(operate);
        //2.3根据参数名称获取第一个参数值。把字符串转化为double类型的数字
        double value2 =Double.parseDouble(request.getParameter("value2"));
        String symbol = request.getParameter("symbol");


        if (operate.equals("+")){
            double value = value1+value2;
            request.setAttribute("msg",value);
        }
        if (operate.equals("-")){
            double value = value1-value2;
            request.setAttribute("msg",value);
        }
        if (operate.equals("*")){
            double value = value1*value2;
            request.setAttribute("msg",value);
        }
        if (operate.equals("/")){
            double value = value1/value2;
            request.setAttribute("msg",value);
        }
        request.setAttribute("value1",value1);
        request.setAttribute("value2",value2);

        request.getRequestDispatcher("/index.jsp").forward(request,response);//请求转发。一种服务器内部资源跳转的方式


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
