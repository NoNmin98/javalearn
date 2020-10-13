package com.lzy.dao;

import com.lzy.JDBCUtils.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: lzy
 * @description: 封装了增删改的通用操作,提供通用方法
 * @date: 2020-10-13-18:58
 */
public abstract class baseDAO {

    //通用的增删改操作v-2.0,通过外面传入一个连接，避免自动关闭连接的提交操作
    public void update(Connection conn,String sql,Object ... agrs)  {
        //Connection conn= null;
        PreparedStatement ps = null;
        try {
            //conn = JDBCUtils.getConnection();
            System.out.println(conn);
            ps = conn.prepareStatement(sql);
            for (int i=0;i<agrs.length;i++){
                ps.setObject(i+1,agrs[i]);//注意参数
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null,ps);
        }
    }

    //通用的查询操作，返回数据表中的一条记录，升级版，适用于事务
    public <T> T getInstance(Connection conn,Class<T> clazz,String sql,Object...agrs) throws Exception{
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i=0;i<agrs.length;i++){
            ps.setObject(i+1,agrs[i]);
        }
        //把获取到的数据存入到结果集中
        ResultSet rs = ps.executeQuery();
        //获取元数据
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        if (rs.next()){
            //创建对象，承接数据，我们使用反射获取具体的类型
            T t = clazz.newInstance();
            for (int i=0;i<columnCount;i++){
                Object value = rs.getObject(i + 1);
                String label = rsmd.getColumnLabel(i + 1);

                Field field = clazz.getDeclaredField(label);
                field.setAccessible(true);
                field.set(t,value);
            }

            return t;
        }
        JDBCUtils.closeResource(conn,ps,rs);
        return null;
    }

    //多个对象的查询操作
    public <T> List<T> getForList(Connection conn,Class<T> clazz,String sql,Object...agrs) throws Exception {
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i=0;i<agrs.length;i++){
            ps.setObject(i+1,agrs[i]);
        }
        ResultSet rs = ps.executeQuery();
        //需要获取到元数据
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        ArrayList<T> list = new ArrayList<>();
        while (rs.next()){
            T t=clazz.newInstance();
            for (int i=0;i<columnCount;i++){
                //获取列值
                Object value = rs.getObject(i + 1);
                //获取列名
                String label = rsmd.getColumnLabel(i + 1);
                Field field=clazz.getDeclaredField(label);
                field.setAccessible(true);
                field.set(t,value);
            }
            list.add(t);
            return list;
        }
        JDBCUtils.closeResource(null,ps,rs);
        return null;
    }
    //查询特殊值的通用方法
    public <T> T getValue(Connection conn,String sql,Object...agrs) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i=0;i<agrs.length;i++){
                ps.setObject(i+1,agrs[i]);
            }
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                //返回一整列数据
                return (T) rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null,ps);
        }
        return null;
    }
}
