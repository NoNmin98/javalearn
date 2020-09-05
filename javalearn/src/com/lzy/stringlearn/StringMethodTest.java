package com.lzy.stringlearn;

import org.junit.Test;

/**
 * @author: lzy
 * @description: String
 * @date: 2020-09-05-22:09
 */
public class StringMethodTest {

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
