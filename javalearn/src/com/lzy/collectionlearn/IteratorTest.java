package com.lzy.collectionlearn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author: lzy
 * @description: Iterator联系
 * @date: 2020-09-14-15:43
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",11));
        coll.add(new String("nihao"));
        coll.add(false);

        Iterator iterator = coll.iterator();
        System.out.println(iterator);//指向的是这个集合的地址
        System.out.println(iterator.next());//第一个元素

        while(iterator.hasNext())// 常用的方法，用来遍历，遍历前判断了是否还要下一个值
        {
            System.out.println(iterator.next());
        }
    }
}
