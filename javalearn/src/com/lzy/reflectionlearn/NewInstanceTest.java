package com.lzy.reflectionlearn;

import org.junit.Test;

import java.util.Random;

/**
 * @author: lzy
 * @description: 通过反射的方式创建对应的运行类的对象
 * @date: 2020-09-25-8:38
 */
public class NewInstanceTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {

        Class<Person> cs = Person.class;
        //neInstance（）：调用此方法，创建对应的运行时类的对象,内部调用的是类的空空参构造器
        //有两个要求。1.有空参构造器。2.构造器权限足够
        Person o = cs.newInstance();
        System.out.println(o);
    }

    //这个例子体现了反射的动态性，也就是在运行时我们才能真正确定这个i的具体值，我们才可以根据需要创建对应的累的对象
    @Test
    public void test2() throws Exception {
        int i = new Random().nextInt(3);//0,1,2
        String cp="";
        switch (i){
            case 0:
                cp="java.util.Date";
                break;
            case 1:
                cp="java.sql.Date";
                break;
            case 2:
                cp="com.lzy.reflectionlearn.Person";
                break;
        }
        Object obj=getInstance(cp);
    }

    /*
    * 创建一个全地址名的类的对象
    * */
    public Object getInstance(String classPath) throws Exception{
        Class cs=Class.forName(classPath);
        return cs.newInstance();
    }
}
