package com.lzy.datalearn;

import org.junit.Test;

import java.util.Date;

/**
 * @author: lzy
 * @description: 日期相关api测试
 * @date: 2020-09-07-7:58
 */
public class DataTimeTest {
    /*java.util.Date类
    *       |--java.sql.Date类
    *
    * 1.两个构造器的使用
    *       构造器1：Date() 创建一个对应当前时间的Date对象
    *       构造器2：创建指定毫秒数的Date对象
    * 2.两个方法的使用欧冠
    *       toString()：显示当前年月日
    *       getTime（）：获取当前date时间戳
    * 3.java.sql.Date对应数据库中的日期类型对象
    *       》如何实例化
    *       》把util.Date对象转换成java.sql.Date对象
    * */
    @Test
    public void test1(){
        //构造器1：Date() 创建一个对应当前时间的Date对象
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.getTime());
        //构造器2：创建指定毫秒数的Date对象
        Date date2=new Date(123123421342135L);
        System.out.println(date2.toString());
        //创建java.sql.Date对象
        java.sql.Date date3=new java.sql.Date(128397541092537L);
        System.out.println(date3);// 6038-10-0
        //转换
        //情况1：多态
        Date date4=new java.sql.Date(234789L);
        java.sql.Date date5=(java.sql.Date) date4;
        //情况2：
        Date date6=new Date();
        //java.sql.Date date7=(java.sql.Date)date6;new一个父类不能强制转换成子类
        java.sql.Date date7=new java.sql.Date(date6.getTime());
    }
}
