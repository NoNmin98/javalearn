package com.lzy.internetlearn;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author: lzy
 * @description: 使用URL获取数据
 * @date: 2020-09-24-11:09
 */
public class URLTest {
    @Test//异常抛出要用try-catch
    public void test1() throws IOException {
        URL url=new URL("http://....../.../...jpg");
        //需要下载资源我们需要开启tomcat
        //获取关于服务器的连接,我们获取的是一个http连接，所以使用HttpURLConnection
        //URLConnection urlConnection = url.openConnection();
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        //真正获取到连接
        urlConnection.connect();
        //拿到一个输入流
        InputStream is = urlConnection.getInputStream();
        //读出发哦本地中
        FileOutputStream fos = new FileOutputStream(".....jpg");
        //正常的传输操作
        byte[] buffer=new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        //关闭连接
        is.close();
        fos.close();
        urlConnection.disconnect();


    }
}
