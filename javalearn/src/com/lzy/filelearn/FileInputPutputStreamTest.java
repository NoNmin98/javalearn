package com.lzy.filelearn;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: lzy
 * @description: 字节流测试
 * @date: 2020-09-21-10:54
 */
public class FileInputPutputStreamTest {

    //测试使用字节流输入文本文件，同样是4步骤，可能会出现异常
    @Test
    public void test1() {

    }

    //实现对图片的复制操作，同样是4步骤
    @Test
    public void test2() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file = new File("testimg.jpg");
            File file1 = new File("copyimg.jpg");

            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //指定路径下的文件复制，包装成方法
    public void copyFile(String src, String dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file = new File(src);
            File file1 = new File(dest);

            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //测试copy函数
    @Test
    public void test3(){
        long start=System.currentTimeMillis();
        String src="bigtestimg.png";
        String dest="bigcopyimg1.png";
        copyFile(src,dest);

        long end=System.currentTimeMillis();//5: 13214    10:6714    1024:82
        System.out.println("*****");
        System.out.println(end-start);

    }



}
