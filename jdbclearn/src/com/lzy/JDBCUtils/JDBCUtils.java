package com.lzy.JDBCUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
    public void closeResource(Connection conn, Statement ps) throws SQLException {
        ps.close();
        conn.close();
    }
}
