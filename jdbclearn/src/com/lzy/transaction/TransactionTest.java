package com.lzy.transaction;

import com.lzy.JDBCUtils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author: lzy
 * @description:
 * @date: 2020-10-12-10:09
 */
public class TransactionTest {

    /*
    user_table中aa给bb转账100
    这个时候如果我们在做完了第一个事务之后出现了各种原因导致的异常，无法使BB增加金钱，
    我们也无法回滚到AA扣钱之前
     */
    @Test
    public void test1(){
        String sql1="update user_table set balance=balance-100 where user=?";
        update(sql1,"AA");
        String sql2="update user_table set balance=balance+100 where user=?";
        update(sql2,"BB");
    }



    //通用的增删改操作v-1.0,这个方法事务一旦执行就无法回滚，把事务拆分的太散，未考虑数据库事务
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
                JDBCUtils.closeResource(conn,ps);
        }
    }

    //考虑了数据库事务的修改版，这个只把两个事务处理成了一个事务，但是我们的DML操作同样会自动提交
    @Test
    public void test2() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            //取消自动提交功能
            conn.setAutoCommit(false);

            String sql1="update user_table set balance=balance-100 where user=?";
            update(conn,sql1,"AA");

            //测试网络拥堵
//            System.out.println(100/0);
            int i=-100/0;
            System.out.println(3);
            String sql2="update user_table set balance=balance+100 where user=?";
            update(conn,sql2,"BB");

            //处理完成提交事务
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //有问题，回滚数据
            try {
                System.out.println(1);
                conn.rollback();
                System.out.println(2);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {

            JDBCUtils.closeResource(conn,null);
        }
    }



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

}
