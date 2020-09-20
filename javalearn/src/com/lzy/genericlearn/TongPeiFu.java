package com.lzy.genericlearn;

import org.junit.Test;

import java.util.List;

/**
 * @author: lzy
 * @description: 通配符的使用
 * @date: 2020-09-20-12:13
 */
public class TongPeiFu {

    @Test
    public void test1(){
        List<Object> list1=null;
        List<String> list2=null;
        List<?> list3=null;
        list3=list1;
        list3=list2;

        show(list1);
        show(list2);

    }

    @Test
    public void test2(){
        List<? extends Person> list1=null;
        List<? super Person> list2=null;

        List<Student> list3=null;
        List<Person> list4=null;
        List<Object> list5=null;

        //得出extends表示小于等于这个类，所以承接需要使用到Person类，相当于(-无穷，Person]
        //写入数据不能写入Student类型的数据，子类可以赋给父类，反之不行。所以如果给了更小类型就会出错。
        list1=list3;
        list1=list4;
        //list1=list5;
        //list1.add(new Student());

        //得出super表示大于等于这个类，所以承接需要使用顶级的父类Object,相当于[Person,+无穷）
        //这个时候只要小于等于Person类就可以，根据区间可知父类类型肯定大于等于Person这个类。
        //list2=list3;
        list2=list4;
        list2=list5;
        list2.add(new Person());
        list2.add(new Student());
    }

    public void show(List<?> list){
        /*Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object obj=iterator.next();
            System.out.println(obj);
        }*/

        System.out.println("***");
    }

}
