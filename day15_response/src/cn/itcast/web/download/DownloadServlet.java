package cn.itcast.web.download;

import cn.itcast.web.utils.DownLoadUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数，就是获取文件名称
        String filename = request.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        //找到文件的真实路径
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2用字节流关联
        FileInputStream fis = new FileInputStream(realPath);
        //3设置响应头类型
        //3.1设置响应头类型Content-Type
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("Content-Type", mimeType);


        //解决中文文件名的问题
        //1.获取user-agent请求头
        String agent = request.getHeader("user-agent");
        //2.使用工具类方法编写文件名即可
        filename = DownLoadUtils.getFileName("agent", filename);

        //3.2设置响应头打开方式 Content-disposition
        response.setHeader("Content-disposition", "attachment;filename=" + filename);


        //4.将输入流的数据写出输出流中
        ServletOutputStream sos = response.getOutputStream();
        //作为缓冲区
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        //循环读取，读取到缓冲区中
        while ((len = fis.read(buff)) != -1) {
            //一直循环写，0到len
            sos.write(buff, 0, len);
        }
        fis.close();
        sos.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
