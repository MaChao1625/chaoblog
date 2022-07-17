package com.offcn.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class StudentDao {
    QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
    public int addStudent(String name,int age,String gender,String email,String phone){
        try{
            return qr.update("insert into student(name,age,gender,email,phone)values(?,?,?,?,?)",name,age,gender,email,phone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
