package com.lzy.maplearn;

import org.junit.Test;

import java.util.*;

/**
 * @author: lzy
 * @description:
 * @date: 2020-09-19-9:40
 */
public class TreeMapTest {

    //自然排序
    @Test
    public void test1(){
        TreeMap tre=new TreeMap();
        User u1=new User("tom",11);
        User u2=new User("cat",42);
        User u3=new User("zoo",1);
        User u4=new User("yel",22);
        //前面是key后面是value
        tre.put(u1,99);
        tre.put(u2,12);
        tre.put(u3,65);
        tre.put(u4,78);

        //遍历
        Set set=tre.entrySet();//返回kye-value对构成的集合
        Iterator it=set.iterator();
        while (it.hasNext()){
            //这一步把迭代器的下一位强制转换成了Map.Entry类型，也就是键值对形式
            Map.Entry entry=(Map.Entry)it.next();
           /* Object obj=it.next();
            Map.Entry entry=(Map.Entry)obj;*/
            //接下来可以直接获取到entry类型的数据
            System.out.println(entry.getKey()+"------"+entry.getValue());
        }
    }

    //定制排序
    @Test
    public void test2() {
        TreeMap tre = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                System.out.println("****");
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    int compare = -u1.getName().compareTo(((User) o2).getName());
                    if (compare != 0) {
                        return compare;
                    } else {
                        return u1.getAge() - u2.getAge();
                    }
                } else {
                    throw new RuntimeException("error1");
                }
            }
        });
        User u1 = new User("tom", 11);
        User u2 = new User("cat", 42);
        User u3 = new User("zoo", 1);
        User u4 = new User("yel", 22);
        //前面是key后面是value
        tre.put(u1, 99);
        tre.put(u2, 12);
        tre.put(u3, 65);
        tre.put(u4, 78);

        //遍历
        Set set = tre.entrySet();//返回kye-value对构成的集合
        Iterator it = set.iterator();
        while (it.hasNext()) {
            //这一步把迭代器的下一位强制转换成了Map.Entry类型，也就是键值对形式
            Map.Entry entry = (Map.Entry) it.next();
           /* Object obj=it.next();
            Map.Entry entry=(Map.Entry)obj;*/
            //接下来可以直接获取到entry类型的数据
            System.out.println(entry.getKey() + "------" + entry.getValue());
        }
    }
}
