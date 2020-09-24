package com.lzy.internetlearn;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: lzy
 * @description: 尝试客户端和服务器连接使用Socket
 * @date: 2020-09-24-8:15
 */
public class CSTest {

    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        try {
            //这个地方输入的是本机ip地址
            InetAddress inet= InetAddress.getByName("127.0.0.1");
            //这个地方添加套接字,参数1指定端口号，参数二：指定端口
            socket = new Socket(inet,8888);
            //获得一个输出流，用来输出数据
            os = socket.getOutputStream();
            os.write("你好!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //注意资源要关闭，socket是没法自己关闭的
            try {
                if (os!=null)
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket!=null)
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    //服务器端，这里要用try-catch,为了好看结构使用throws
    @Test
    public void server() throws IOException {
        //确认自己的端口号，用来接收
        ServerSocket ss = new ServerSocket(8888);
        //可以用来接收socket
        Socket socket=ss.accept();
        //创建一个接收的对象
        InputStream is =socket.getInputStream();
        //为了防止服务器传输的内容过多我们没法使用read在一个字节数组中完全处理完毕
        //我们使用数组循环接收
        //但是！！！！！！！！！！！不建议这样写，因为中文，无论数组有多大，都可能会直线乱码
        byte[] bytes = new byte[100];
        int len;
        while ((len=is.read(bytes))!=-1){
            String string = new String(bytes,0,len);
            System.out.println(string);
        }
        System.out.println(socket.getInetAddress().getHostAddress());


    }
}
