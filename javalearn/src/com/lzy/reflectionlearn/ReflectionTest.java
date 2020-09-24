package com.lzy.reflectionlearn;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: lzy
 * @description: 反射实例举例
 *                在反射之前我们是不能电泳Person类的对象和调用其内容部的私有结构的
 * @date: 2020-09-24-19:24
 */
public class ReflectionTest {
    @Test
    public void test1() throws Exception {
        Class<Person> cs = Person.class;
        //通过反射，创建Person类的对象
        Constructor con= cs.getConstructor(String.class,int.class);
        Object obj = con.newInstance("Tom", 12);
        //System.out.println(obj.toString());;
        Person p= (Person) obj;
        System.out.println(p.toString());
        //通过反射，调用对象指定的属性和方法
        //调用属性
        Field age = cs.getDeclaredField("age");
        age.set(p,15);
        System.out.println(p.toString());
        //调用方法
        Method show = cs.getDeclaredMethod("show");
        show.invoke(p);
        //通过反射，可以调用私有结构
        //调用私有构造器
        Constructor<Person> con1 = cs.getDeclaredConstructor(String.class);
        con1.setAccessible(true);
        Person p1 = con1.newInstance("jerry");
        System.out.println(p1);
        //调用私有属性
        Field name = cs.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"nihao");
        System.out.println(p1);
        //调用私有方法
        Method showNation = cs.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        //相当于String nation=p1.showNation("中国");
        String nation = (String) showNation.invoke(p1, "中国");
        System.out.println(nation);

    }
}
