package com.lzy.collectionlearn;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author: lzy
 * @description: 用来测试Collection中接口的方法
 * @date: 2020-09-14-11:10
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll=new ArrayList();//这个地方就是多态
        //添加元素e到集合中
        coll.add("aa");
        coll.add(123);//自动装箱
        //获取元素个数
        System.out.println(coll.size());
        //addAll()
        Collection coll1=new ArrayList();
        coll1.add("bb");
        coll1.add("cc");
        coll.addAll(coll1);

        System.out.println(coll.isEmpty());

        coll1.clear();

        coll.add(new String("Tom"));
        coll.add(new Person("ni",20));//可以放入自定义类
        boolean contains1=coll.contains(123);
        System.out.println(contains1);
        System.out.println(coll.contains(new String("Tom")));//true
        System.out.println(coll.contains(new Person("ni",20)));//false,如果重写equals方法就可以成为true，如果不重写就是Object的equals（）

        //containsAll(Collection coll2)判断是否coll1都在coll中
        Collection coll2= Arrays.asList(123,4567);
        System.out.println(coll.containsAll(coll2));

        coll.remove(123);
        //删除coll1中的coll2的所有元素。
        coll1.removeAll(coll2);

        //获取交集。
        coll1.retainAll(coll2);

        //完全相同返回true，包括顺序也要相同。
        coll.equals(coll2);

        //hashCode()返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //集合-->数组
        Object[] arr=coll.toArray();
        for (int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }

        //数组-->集合
        List<String> strings = Arrays.asList(new String[]{"aa", "bb", "cc"});
        System.out.println(strings);

        List arr1=Arrays.asList(new int[]{123,456});
        System.out.println(arr1.size());//1,通过下面的输出可以看出，系统把整个arr1当做了一个整体，而不是单独的两个
        System.out.println("==============================");
        System.out.println(arr1);//  [[I@4f2410ac]

        List arr2=Arrays.asList(new Integer[]{123,456});
        System.out.println(arr2.size());//2
        System.out.println(arr2);// [123, 456]

        //iterator迭代器接口,用于集合元素的遍历
    }
}
