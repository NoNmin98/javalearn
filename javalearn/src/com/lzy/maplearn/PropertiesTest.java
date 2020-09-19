package com.lzy.maplearn;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author: lzy
 * @description: properties配置测试,没有严格遵循写法
 * @date: 2020-09-19-10:41
 */
public class PropertiesTest {


    public static void main(String[] args) throws Exception{
            //创建对象
            Properties pr=new Properties();
            //读入文件
            FileInputStream fis=new FileInputStream("jdbc.properties");
            //加载流对应的文件
            pr.load(fis);
            //获取配置文件中的属性
            String name=pr.getProperty("name");
            String pwd=pr.getProperty("pwd");
            System.out.println("name:"+name+" "+"pwd:" + pwd);
    }
}
