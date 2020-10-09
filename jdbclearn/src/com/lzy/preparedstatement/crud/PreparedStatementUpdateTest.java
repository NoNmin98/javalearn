package com.lzy.preparedstatement.crud;

import com.lzy.JDBCUtils.JDBCUtils;
import connection.ConnectionTest;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @author: lzy
 * @description: 学习PreparedStatement
 * @date: 2020-10-08-15:15
 */
public class PreparedStatementUpdateTest {
    //测试增加一个数据
    //注意这个同样需要用try-catch来处理异常，和之前一样，关闭操作放到finally中
    //为了结构完整好看这里不用try-catch
    @Test
    public void test1() throws Exception {
        //读取配置文件中的加载信息
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);
        String user = pros.getProperty("user");
        String pwd = pros.getProperty("pwd");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");
        //加载驱动
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, user, pwd);

        //插入数据,?是占位符，正式这个占位符解决了上述的弊端，返回PrepareStatement的实例
        String sql="insert into customers(name,email,birth)values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        //填充占位符，注意和数据库交互索引从1开始
        //setDate对应数据库中的date
        ps.setString(1,"niHao");
        ps.setString(2,"lzy@gmail.com");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse("0001-01-01");
        ps.setDate(3,new java.sql.Date(parse.getTime()));
        //执行操作
        ps.execute();
        //资源关闭
        ps.close();
        connection.close();
        is.close();
    }
    //修改一条记录,要使用try-catch
    @Test
    public void test2() throws Exception {
        //获取数据库连接
        Connection conn = JDBCUtils.getConnection();
        //预编译sql语句，返回preparedStatement实例
        String sql="update customers set name =? where id= ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        //填充占位符
        ps.setString(1,"莫扎特");
        ps.setObject(2,18);
        //执行
        ps.execute();
        //资源关闭
        JDBCUtils.closeResource(conn,ps);
    }

    //通用的增删改操作
    //sql中可变形参的长度，等于占位符的个数
    public void update(String sql,Object ... agrs)  {
        Connection conn= null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i=0;i<agrs.length;i++){
                ps.setObject(i+1,agrs[i]);//注意参数
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.closeResource(conn,ps);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //测试通用操作
    @Test
    public void test3(){
        String sql="delete from customers where id=?";
        update(sql,21);
    }

}
