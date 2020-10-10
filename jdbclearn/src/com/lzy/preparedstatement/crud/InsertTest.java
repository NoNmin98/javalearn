package com.lzy.preparedstatement.crud;

import com.lzy.JDBCUtils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author: lzy
 * @description: 使用prepareStatement批量插入数据
 * @date: 2020-10-10-9:38
 */
public class InsertTest {
    //方式1：
    @Test
    public void test1() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        String sql="insert into goods(name)values(?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i=0;i<20000;i++){
            ps.setString(1,"name_"+i);

            ps.execute();
        }
        JDBCUtils.closeResource(conn,ps);
    }

    //批量插入的方法2：使用batch
    @Test
    public void test2() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        String sql="insert into goods(name)values(?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i=0;i<20000;i++){
            ps.setString(1,"name_"+i);
            //攒sql语句一起执行!!!!!!!!!!!!!!!!
            ps.addBatch();
            if(i%500==0){
                ps.executeBatch();
                ps.clearBatch();
            }
        }
        JDBCUtils.closeResource(conn,ps);
    }
    //批量插入的方法3：使用batch,并且更改连接设置，取消自动提交，只有在我们所有操作都完成的情况下,最高效
    @Test
    public void test3() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        //设置不允许自动提交!!!!!!!!!!
        conn.setAutoCommit(false);
        String sql="insert into goods(name)values(?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i=0;i<20000;i++){
            ps.setString(1,"name_"+i);
            //攒sql语句一起执行
            ps.addBatch();
            if(i%500==0){
                ps.executeBatch();
                ps.clearBatch();
            }
        }
        //最后统一提交数据
        conn.commit();
        JDBCUtils.closeResource(conn,ps);
    }
}
