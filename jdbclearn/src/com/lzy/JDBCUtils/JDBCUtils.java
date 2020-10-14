package com.lzy.JDBCUtils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author: lzy
 * @description: jdbc工具类
 * @date: 2020-10-08-15:50
 */
public class JDBCUtils {

    public static Connection getConnection() throws Exception {
        //读取配置文件中的加载信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);
        String user = pros.getProperty("user");
        String pwd = pros.getProperty("pwd");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");
        //加载驱动
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, user, pwd);
        return connection;
    }
    //注意这里需要使用try-catch处理异常
    public static void closeResource(Connection conn, Statement ps) {
        try {
            if (conn!=null)
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps!=null)
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        try {
            if (conn!=null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps!=null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs!=null)
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //使用druid数据库连接池建立连接
    private static DataSource source;
    //使用静态代码块
    static{
        //创建一个配置文件对象
        try {
            Properties pros = new Properties();
            FileInputStream fis=new FileInputStream(new File("src/druid.properties"));
            pros.load(fis);
            source = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection1() throws SQLException {

        Connection conn =  source.getConnection();
        return conn;
    }




}
