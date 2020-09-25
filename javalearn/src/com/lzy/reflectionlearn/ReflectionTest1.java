package com.lzy.reflectionlearn;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: lzy
 * @description: 通过反射调用运行时类的指定属性
 * @date: 2020-09-25-10:38
 */
public class ReflectionTest1 {
    //调用属性
    @Test
    public void test() throws Exception {
        //获取运行时类
        Class<Person> p = Person.class;
        //创建一个类的对象
        Person person = p.newInstance();
        //获取指定的属性,这个时候我们需要指定的是这个运行时类的属性，所以使用p
        //用这个方法我们需要指定属性为public，在开发中不常用
        //Field ages =p.getField("age");

        //开发中常用getDeclaredField,注意如果需要先设置为可以访问的才能修改数据
        Field ages=p.getDeclaredField("age");
        ages.setAccessible(true);

        //指定属性赋值,我们是把值赋给一个具体的对象，所以使用person
        ages.set(person,11);
    }
    //调用方法
    @Test
    public void test1() throws Exception{
        //获取运行时类
        Class<Person> p = Person.class;
        //创建对应对象
        Person person = p.newInstance();
        //获取指定的某个方法
        //参数1：指明获取的方法的名称，参数二：由于重载我们需要指明形参
        Method show = p.getDeclaredMethod("showNation", String.class);
        //保证当前方法可访问
        show.setAccessible(true);
        //调用
        //参数一：方法的调用者，给方法新参赋值的实参
        //此方法有返回值，就是对应类中调用的方法的返回值
        show.invoke(person,"CHN");

        //如何调用静态方法
        Method show1 = p.getDeclaredMethod("show1");
        show1.setAccessible(true);
        show1.invoke(p);
    }
}
