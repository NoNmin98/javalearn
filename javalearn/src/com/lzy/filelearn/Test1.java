package com.lzy.filelearn;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: lzy
 * @description: 对图片进行加密和解密
 * @date: 2020-09-21-15:25
 */
public class Test1 {
    //对图片加密
    @Test
    public void test1(){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            fis = new FileInputStream(new File("testimg.jpg"));
            fos = new FileOutputStream(new File("testimgsecret.jpg"));

            byte[] buffer=new byte[20];
            int len;
            //使用read方法吧文件读入到buffer数组中，len获取每次取得的数组的长度，没取得为-1。
            while ((len=fis.read(buffer))!=-1){

                //在写入文件的时候需要加密
                for (int i=0;i<len;i++){
                    buffer[i]= (byte) (buffer[i]^5);
                }

                //吧数组中的数据写入到fos流中，fos流再写入到文件中。
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if(fis!=null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos!=null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //对图片解密
    @Test
    public void test2(){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            fis = new FileInputStream(new File("testimgsecret.jpg"));
            fos = new FileOutputStream(new File("testimg1.jpg"));

            byte[] buffer=new byte[20];
            int len;
            //使用read方法吧文件读入到buffer数组中，len获取每次取得的数组的长度，没取得为-1。
            while ((len=fis.read(buffer))!=-1){

                //在写入文件的时候需要加密
                for (int i=0;i<len;i++){
                    buffer[i]= (byte) (buffer[i]^5);
                }

                //吧数组中的数据写入到fos流中，fos流再写入到文件中。
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if(fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos!=null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
