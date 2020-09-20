package com.lzy.filelearn;

import org.junit.Test;

import java.io.File;

/**
 * @author: lzy
 * @description: 学习File类
 * @date: 2020-09-20-18:55
 */
public class FileTest {
    @Test
    public void test1(){
        //构造器1
        File file=new File("hello.txt");//相对于当前module也就是javalearn
        File file1=new File("E:\\IDEAProjects\\learn\\javalearn\\src\\com\\lzy\\filelearn");
        System.out.println(file);

        //构造器2
        File file2=new File("E:\\IDEAProjects","learn\\javalearn\\src\\com\\lzy\\filelearn");
        System.out.println(file2);
        //构造器3
        File file3=new File(file2,"hi.txt");
        System.out.println(file3);
    }
}
