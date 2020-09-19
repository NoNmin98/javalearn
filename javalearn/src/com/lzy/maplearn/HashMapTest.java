package com.lzy.maplearn;

import org.junit.Test;

import java.util.*;


/**
 * @author: lzy
 * @description: map接口测试
 * @date: 2020-09-19-8:33
 */
public class HashMapTest {
    @Test
    public void test1(){
        Map hm = new HashMap();
        hm.put("AA",24);
        hm.put(234,234);
        hm.put(12,232);
        hm.put("AA",55);
        Map hm1=new HashMap(hm);
        System.out.println(hm.size());
        System.out.println(hm.isEmpty());
        System.out.println("*************************");
        System.out.println(hm.equals(hm1));
    }
    @Test
    public void test2() {
        Map hm = new HashMap();
        hm.put("AA", 24);
        hm.put(234, 234);
        hm.put(12, 232);
        hm.put("AA", 55);
        Set set = hm.keySet();
        //System.out.println(set);
        /*while (set.iterator().hasNext()){//一直输出第一个key
            System.out.println(set.iterator().next());*/
        Iterator it = set.iterator();//正常输出
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        //获取value值
        Collection values = hm.values();
        Iterator ite = values.iterator();
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }

        System.out.println("*******");
        //获取key-value
        Set set1 = hm.entrySet();
        Iterator ite1 = set1.iterator();
        while (ite1.hasNext()) {
            System.out.println(ite1.next());
        }
        System.out.println("***************");
        Iterator ite2 = set1.iterator();
        while (ite2.hasNext()) {
            /*Object en=ite2.next();
            Map.Entry entry=(Map.Entry)en;*/
            Map.Entry entry=(Map.Entry)ite2.next();
            System.out.println(entry);
        }
    }
}
