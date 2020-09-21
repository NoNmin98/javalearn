package com.lzy.filelearn;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: lzy
 * @description: 文件流测试,，读入文件需要存在
 * @date: 2020-09-21-9:01
 */
public class FileReaderWriterTest {
    @Test
    public void test1() {
        FileReader fr = null;
        try {
            File file = new File("jo.txt");//相较于当前module
            //提供具体的流
            fr = new FileReader(file);
            //数据的读入
            //read():返回读入的一个字符。如果到末尾，返回-1
            int data = fr.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流的关闭。一定要手动关闭，gc没法自动关闭物理连接
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @Test
    public void test2() {
        FileReader fileReader = null;
        try {
            //1.File类的实例化
            File file = new File("jo.txt");
            //2.FileReader流的实例化
            fileReader = new FileReader(file);
            //3.读入的操作
            //每次读入5个
            char[] cbuf = new char[5];
            fileReader.read(cbuf);
            int len;
            //System.out.println(cbuf);
            //read(char[] cbuf)返回每次读入到数组中的字符的个数，如果到了末尾返回-1
            while ((len = fileReader.read(cbuf)) != -1) {
                //for(int i=0;i<cbuf.length;i++)错误写法，因为数组用的同一个数组，覆盖操作，
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }


    @Test
    public void testFileWriter() {
        FileWriter fw = null;
        try {
            //1.提供File对象，获取文件
            File file = new File("hello.txt");
            //2.提供FileWriter对象，用于数据写出
            fw = new FileWriter(file, false);
            //3.写出操作
            fw.write("hello");
            fw.write("write");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭
            if (fw != null) {

                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void testFileReaderFileWriter() {
        FileWriter fw = null;
        FileReader fr = null;
        try {
            //1.创建File类对象，支出需要操作的文件
            File srcFile = new File("jo.txt");
            File destFile = new File("hello.txt");
            //2.创建输入流和输出流的文件
            fw = new FileWriter(srcFile);
            fr = new FileReader(destFile);
            //3.数据的读入写出
            char[] cbuf = new char[5];
            int len;//用来保存每次读入到cbuf数组中的数据的个数
            while ((len = fr.read(cbuf)) != -1) {
                //每次写出len个字符
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            //可以这样写，同样可以把这个第二个关闭放到finally中
            //因为try-catch相当于把异常处理掉了，和throws方法不同，try-catch后面的方法同样会继续执行
            try {
                if (fw!=null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
