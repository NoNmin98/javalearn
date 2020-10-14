package com.lzy.connection;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author: lzy
 * @description: 测试德鲁伊数据库连接池
 * @date: 2020-10-14-9:37
 */
public class DruidTest {
    @Test
    public void getConnection() throws Exception {
        //创建一个配置文件对象
        Properties pros = new Properties();
        FileInputStream fis=new FileInputStream(new File("src/druid.properties"));
        pros.load(fis);
        DataSource source = DruidDataSourceFactory.createDataSource(pros);
        Connection conn = source.getConnection();
        System.out.println(conn);
    }
}
