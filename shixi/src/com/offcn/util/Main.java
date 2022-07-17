package com.offcn.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;



import java.sql.SQLException;

public class Main {
    static QueryRunner qr = new QueryRunner(new ComboPooledDataSource());

    @Test
    public void insert() throws SQLException {
        System.out.println(qr.update("insert into user values(?,?)","admin2","4646"));
    }
    @Test
    public void update() throws SQLException {
        System.out.println(qr.update("update user set password = ? where username = ?","88888","admin2"));
    }

    @Test
    public void delete() throws SQLException {
        System.out.println(qr.update("delete from user where username = ?","admin2"));
    }

}
