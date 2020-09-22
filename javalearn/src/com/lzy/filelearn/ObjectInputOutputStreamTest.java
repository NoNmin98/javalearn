package com.lzy.filelearn;

import org.junit.Test;

import java.io.*;

/**
 * @author: lzy
 * @description: 对象流的输入输出
 * @date: 2020-09-22-17:48
 */
public class ObjectInputOutputStreamTest {
    //对象序列化
    @Test
    public void test1() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("testoos.dat")));
            Person<String> per = new Person<>("nihao", 12, "ceshi");
            oos.writeObject(per);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    //对象反序列化
    @Test
    public void test2() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("testoos.dat")));

            Object per = ois.readObject();
            System.out.println(per);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
