package com.lzy.setlearn;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author: lzy
 * @description: 写一个TreeSet例题
 * @date: 2020-09-16-14:31
 */
public class TreeSetTest {

    //使用自然排序,使Employee实现全Comparable接口，并且按照name排序
    @Test
    public void test1(){
        TreeSet set =new TreeSet();

        Employee e1=new Employee("name1",1,new MyDate(1990,1,1));
        Employee e2=new Employee("name4",4,new MyDate(1923,3,23));
        Employee e3=new Employee("name3",3,new MyDate(1978,6,12));
        Employee e4=new Employee("name4",8,new MyDate(1998,3,18));
        Employee e5=new Employee("name5",23,new MyDate(1999,3,31));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        //System.out.println(set);
        Iterator iterable=set.iterator();
        while(iterable.hasNext())
            System.out.println(iterable.next());
        }

        //定制排序，按照生日顺序进行排序
        @Test
    public void test2(){
            TreeSet set =new TreeSet(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    if(o1 instanceof Employee && o2 instanceof Employee){
                        Employee e1=(Employee)o1;
                        Employee e2=(Employee)o2;
                        MyDate b1=e1.getBirthday();
                        MyDate b2=e2.getBirthday();
                        int sumYear=b1.getYear()-b2.getYear();
                        int sumMonth=b1.getMonth()-b2.getMonth();
                        System.out.println("*******");
                        if(sumYear!=0)
                            return sumYear;//是通过差值进行比较
                        if(sumMonth!=0)
                            return sumMonth;
                        return b1.getDay()-b2.getDay();

                    }
                    throw new RuntimeException("error1");
                }
            });

            Employee e1=new Employee("name1",1,new MyDate(1990,1,1));
            Employee e2=new Employee("name4",4,new MyDate(1923,3,23));
            Employee e3=new Employee("name3",3,new MyDate(1978,6,12));
            Employee e4=new Employee("name4",8,new MyDate(1998,3,18));
            Employee e5=new Employee("name5",23,new MyDate(1999,3,31));
            set.add(e1);
            set.add(e2);
            set.add(e3);
            set.add(e4);
            set.add(e5);
            Iterator iterable=set.iterator();
            while(iterable.hasNext())
                System.out.println(iterable.next());
        }
}
