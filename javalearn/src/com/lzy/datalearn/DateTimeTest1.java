package com.lzy.datalearn;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: lzy
 * @description:
 * @date: 2020-09-07-9:28
 */
public class DateTimeTest1 {
    //SimpleDateFormat对日期Date类的格式化和解析
    //SimpleDateFormat实例化
    @Test
    public void test() throws ParseException {
        //实例化
        SimpleDateFormat sdf = new SimpleDateFormat();
        //格式化：日期->字符串
        Date date = new Date();
        String format=sdf.format(date);
        System.out.println(format);
        //解析:字符串->日期
        String str="20-9-7 上午9:33";
        Date date1=sdf.parse(str);
        System.out.println(date1);
        //指定格式的日期:通过带参数的构造器
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1=sdf1.format(date);
        System.out.println(format1);
        //解析
        Date date2=sdf1.parse("2020-09-07 09:41:25");
        System.out.println(date1);

    }
    //把指定格式的字符串转换成java.sql./Date格式
    @Test
    public void test1() throws ParseException {
        String d="2020-09-07";
        //首先需要使用到SimpleDateFormat对象,使用带参数的构造器
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //解析这个时间并且把它赋值给一个Date类型对象
        Date date=sdf.parse(d);
        //然后把这个Date类型转换成java.sql.Date类型，需要使用getTime（）
        java.sql.Date date1=new java.sql.Date(date.getTime());
        System.out.println("***************************");
        System.out.println(date1);
    }
}
