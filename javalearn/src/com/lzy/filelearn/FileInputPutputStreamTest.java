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
    public void copyx






}
