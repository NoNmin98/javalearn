package com.lzy.dbutils;

import com.lzy.JDBCUtils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: lzy
 * @description: Apache封装了针对数据库的cudr操作
 * @date: 2020-10-14-10:35
 */
public class QueryRunnerTest {

    //测试插入
    @Test
    public void test1() throws SQLException {
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection1();
        String sql="insert into customers(name,email,birth)values(?,?,?)";
        int co = runner.update(conn, sql, "蔡徐坤", "cai@123.com", "1997-09-09");
        System.out.println(co);
        JDBCUtils.closeResource(conn,null);
    }
}
