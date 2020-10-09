package com.lzy.preparedstatement.crud;

import com.lzy.JDBCUtils.JDBCUtils;
import com.lzy.bean.Customer;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**

/**
 @author: lzy
 @description: 针对Customer表的查询
 @date: 2020-10-09-9:39
 @Param $
 @return $
 */
public class CustomerForQuery {
    //try-catch
    @Test
    public void test1() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        String sql="select id,name,email,birth from customers where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,1);
        //和之前不一样，这次我们需要返回一个集合存结果集
        ResultSet rs = ps.executeQuery();
        //处理结果集
        if (rs.next()){//这个方法会指针下移
            int id=rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            Date birth = rs.getDate(4);

            //最好的方式是使用对象实例去承接
            Customer customer = new Customer(id, name, email, birth);
            System.out.println(customer);
        }
        //资源关闭
        JDBCUtils.closeResource(conn,ps,rs);
    }

    //通用查询Customer的操作
    public Customer queryForCustomers(String sql,Object...agrs) throws Exception {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        //填充占位符
        for (int i=0;i<agrs.length;i++){
            ps.setObject(i+1,agrs[i]);
        }
        //返回结果集,因为只返回一条所以使用if
        ResultSet rs = ps.executeQuery();
        //获取结果集的元数据：数据是主要的，但是数据的类型，名称，我们称之为元数据
        ResultSetMetaData rsmd = rs.getMetaData();
        //我们可以通过元数据来取得结果集中的列数
        int columnCount = rsmd.getColumnCount();
        if (rs.next()){
            //创建对象承接数据
            Customer customer = new Customer();
            //需要确认列数是因为我们需要确定 我们动态获取的行数据中的哪几列
            for (int i=0;i<columnCount;i++){
                //从结果集中获取列值
                Object columnValue = rs.getObject(i + 1);
               /* 接下来我们需要确认获取到的数据是哪一个属性，并且把这个属性数据填充到我们的对象中
                因为我们这个时候还没有写我们所需要的的sql语句，所以我们没法确定我们究竟是需要的数据类型是什么，
                所以我们需要使用反射来动态获取属性和数据。
                */
               //获取每个列的列名,因为数据库从1开始
                String columnName = rsmd.getColumnName(i + 1);
                //给customer对象指定的columnName属性，赋值为columnValue，未知类型，使用反射
                Field df = Customer.class.getDeclaredField(columnName);
                df.setAccessible(true);
                df.set(customer,columnValue);
            }
            JDBCUtils.closeResource(conn,ps,rs);
            return customer;
        }
        JDBCUtils.closeResource(conn,ps,rs);

        return null;
    }

    @Test
    public void test3() throws Exception {
        String sql="select id,name,birth from customers where id=?";
        Customer customer = queryForCustomers(sql, 6);
        System.out.println(customer);

    }
}
