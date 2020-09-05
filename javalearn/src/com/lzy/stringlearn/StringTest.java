package com.lzy.stringlearn;

import org.junit.Test;

/**
 * @author: lzy
 * @description: String学习
 * @date: 2020-09-05-21:25
 */
public class StringTest {

    public  void change(String str){
        str="just so so";
    }
    public String change1(String str){
        str="just so so 1";
        return str;
    }

    @Test
    public void test1(){
        String s1="hello world";
        String s2=new String("good");
        s2="bad";
        s1="world hello";
        System.out.println(s1);
        System.out.println(s2);
        change(s2);
        System.out.println(s2);//bad
        String s3=change1(s2);
        System.out.println(s3);//just so so 1
        System.out.println(s3==s2);//false
    }
    
}
