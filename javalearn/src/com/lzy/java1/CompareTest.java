package com.lzy.java1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: lzy
 * @description: Compare比较器学习
 * @date: 2020-09-12-19:05
 */
public class CompareTest {

    @Test
    public void test1()
    {
        Goods[] arr=new Goods[4];
        arr[0]=new Goods("11",1);
        arr[1]=new Goods("22",3);
        arr[2]=new Goods("33",2);
        arr[3]=new Goods("44",4);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test2(){
        String[] arr=new String[]{"aa","bb","kk","gg","mm"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);//从大到小
            }
        });
        System.out.println(Arrays.toString(arr));
    }

}
