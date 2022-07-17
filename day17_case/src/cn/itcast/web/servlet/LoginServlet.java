package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("登录服务器的"+request);
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //2.获取数据
        //2.1获取用户填写的验证码
        String verifycode = request.getParameter("verifycode");//通过名字获取用户的值
        //3.对验证码进行校验
        HttpSession session = request.getSession();
            //强制类型转化为String类型
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");//从session中根据早到生成的验证码。进行一个强制转化
        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性，用完之后就移除
        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            //1.验证码不正确
            //2.提示信息
            request.setAttribute("login_msg","验证码错误");
            //3.跳转到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);//请求转发。一种服务器内部资源跳转的方式
            return;
        }
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        //4.封装User对象
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //5.调用Service查询
        UserService service = new UserServiceImpl();
        User loginUser=service.login(user);

        //6.判断是否登录成功
        if (loginUser!=null){
            //登录成功
            //将用户存入session中
            session.setAttribute("user",loginUser);
            //跳转页面(重定向)
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            //登录失败
            //提示信息
            request.setAttribute("login_msg","用户名或密码错误");
            //3.跳转到登录页面（转发）
            request.getRequestDispatcher("/login.jsp").forward(request,response);//请求转发。一种服务器内部资源跳转的方式
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
