package com.lzy.stringlearn;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author: lzy
 * @description: String
 * @date: 2020-09-05-22:09
 */
public class StringMethodTest {


    @Test
    public void test2(){
        String s="abc中国";
        byte[] bytes=s.getBytes();//默认使用utf-8
        byte[] bytes2=null;
        try {
            bytes2=s.getBytes("gbk");//使用gbk编码集
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(bytes2));

    }

    @Test
    public void test1(){
        String s="HelloWorld";
        String s2=s.toLowerCase();
        System.out.println(s);//HelloWorld ,体现出s的不可变性
        System.out.println(s2);//helloworld

        String s3="abc";
        String s4="abe";
        System.out.println(s3.compareTo(s4));//用于比较字符串大小（通过ascii比较），大于的为正，小于为负，相等为0，常用于排序（例如通讯录）
    }


}
