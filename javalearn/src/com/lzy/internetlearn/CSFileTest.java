package com.lzy.internetlearn;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: lzy
 * @description: CS发送接收文件联系,并且反馈
 * @date: 2020-09-24-8:47
 */
public class CSFileTest {

    @Test
    public void client(){
        Socket socket = null;
        OutputStream os= null;
        FileInputStream fis= null;
        InputStream is=null;
        try {
            //创建了一个匿名的InetAddress独享，创建了一个socket,进行连接
            socket = new Socket(InetAddress.getByName("127.0.0.1"),8888);
            //创建输出流，用来发送字节流
            os = socket.getOutputStream();
            //本身我需要获取到本地的一个文件，所以我需要input
            fis = new FileInputStream(new File("testimg.jpg"));
            //具体读和写的过程
            byte[] buffer=new byte[1024];
            int len;
            while ((len=fis.read(buffer))!=-1){
                //再次提醒这样是为了防止读取到重复数据
                os.write(buffer,0,len);
            }
            //强制关闭!!!,在这里关闭，因为如果在后面关闭的话程序没法到达
            socket.shutdownOutput();
            //用来接收服务器端的反馈
            is = socket.getInputStream();
            //由于反馈的是中文，所以同样需要注意乱码问题
            byte[] buffer1=new byte[1024];
            int len1;
            while ((len1=is.read(buffer1))!=-1){
                is.read(buffer1, 0, len1);
                String s = new String(buffer1, 0, len1);//使用这个构造器方法我们可以吧二进制的流转换成一个string类型的数组
                System.out.println(s);
            }
            System.out.println(is.toString());//如果使用这个方法，传输回来的是一个地址值，所以使用上述方法

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is!=null)
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis!=null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    @Test
    public void server() {
        ServerSocket ss = null;
        InputStream is= null;
        OutputStream os=null;
        FileOutputStream fos= null;
        try {
            //创建socket，服务器是不需要地址的，只需要接收来自客户端的数据即可。
            ss = new ServerSocket(8888);
            //接收获取的socket
            Socket accept = ss.accept();
            //创建输入流
            is = accept.getInputStream();
            //获取的文件保存在本地目录下
            fos = new FileOutputStream(new File("nettestimg3.jpg"));
            //具体传输过程
            byte[] buffer=new byte[1024];
            int len;
            while ((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            System.out.println("文件传输成功！！！");
            //在此基础上给客户端一个反馈
            os=accept.getOutputStream();
            os.write("成功接收到数据".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os!=null)
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos!=null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is!=null)
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ss!=null)
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
