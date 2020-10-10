package com.lzy.blob;

import com.lzy.JDBCUtils.JDBCUtils;
import com.lzy.bean.Customer;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

/**
 * @author: lzy
 * @description: 使用PrepareStatement操作Blob类型的数据
 * @date: 2020-10-10-8:40
 */
public class BlobTest {
    @Test
    public void test1() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        String sql="insert into customers(name,email,birth,photo)values(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,"白展堂");
        ps.setObject(2,"bai@qq.com");
        ps.setObject(3,"1992-09-09");
        //对于文件我们都是使用文件传输
        FileInputStream is = new FileInputStream(new File("testimg.jpg"));
        ps.setBlob(4,is);

        ps.execute();

        JDBCUtils.closeResource(conn,ps);

    }
    //try-catch
    @Test
    public void test2() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        String sql="select id,name,email,birth,photo from customers where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,19);
        InputStream is =null;
        FileOutputStream fos =null;
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            //方式1
            int id = rs.getInt(1);
            String name=rs.getString(2);
            String email=rs.getString(3);
            Date birth=rs.getDate(4);
            //方式2，这个方式可以打乱顺序
            //int id=rs.getInt("id");
            //.....
            new Customer(id,name,email,birth);
            //使用流的方式获取到大数据blob
            //讲blob类型的字段下载下来，使用文件的方式保存到本地
            Blob photo = rs.getBlob("photo");
            is = photo.getBinaryStream();//获取到流
            fos = new FileOutputStream("testimg1.jpg");//输出到本地
            byte[] buffer =new byte[1024];
            int len;
            while ((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }

        }
        JDBCUtils.closeResource(conn,ps,rs);
        is.close();
        fos.close();
    }
}
