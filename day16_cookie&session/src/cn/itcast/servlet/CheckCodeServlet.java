package cn.itcast.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/*字节输出流*/
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        //1.创建一个对象，在内存中图片（验证码的图片对象）
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        //2，美化图片
        //2.1填充背景颜色
        Graphics g = image.getGraphics();//画笔对象
        //设置画笔颜色
        g.setColor(Color.pink);

        g.fillRect(0, 0,width,height);//填充矩形
        //2.2画边框
        g.setColor(Color.blue);
        g.drawRect(0, 0, width - 1, height- 1);//边框占一个像素，所以要减去1
        //2.3生成随机角标
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwsyz1234567890";
        Random ran = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=4; i++) {

            //获取随机角标
            int index = ran.nextInt(str.length());
            //根据随机角标也就是索引，在str变量中找到对应的字符
            //获取字符
            char ch = str.charAt(index);
            sb.append(ch);
            //2.3写验证码
            g.drawString(ch+"",width/5*i,height/2);//写要写一个字符串最简单的方法是ch+""
        }
        String checkCode_session = sb.toString();
        //将验证码存入session
        request.getSession().setAttribute("checkCode_session",checkCode_session);


        //2.4画干扰线
        g.setColor(Color.green);
        for (int i = 0; i <10 ; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1,x2,y1,y2);


        }


        //3.将图片输出到页面展示
        ImageIO.write(image, "jpg", response.getOutputStream());


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
