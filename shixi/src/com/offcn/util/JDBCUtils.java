package com.offcn.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    //初始化数据
    static {
    Properties pt = new Properties();
        try {
            pt.load(new FileInputStream("F:\\idea_daima\\JAVA_Web\\shixi\\jdbc.properties"));
            driver = pt.getProperty("driver");
            url = pt.getProperty("url");
            user = pt.getProperty("user");
            password = pt.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //加载驱动
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取链接
    public static Connection getConn(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //关闭资源
    public static void choseAll(ResultSet rs, Statement stmt, Connection conn ){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


