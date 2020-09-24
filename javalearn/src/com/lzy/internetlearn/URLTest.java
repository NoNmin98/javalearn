package com.lzy.internetlearn;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author: lzy
 * @description: 使用URL获取数据
 * @date: 2020-09-24-11:09
 */
public class URLTest {
    @Test
    public void test1() throws IOException {
        URL url=new URL("http:......");
        //需要下载资源我们需要开启tomcat
        //获取关于服务器的连接,我们获取的是一个http连接，所以使用HttpURLConnection
        URLConnection urlConnection = url.openConnection();
    }
}
