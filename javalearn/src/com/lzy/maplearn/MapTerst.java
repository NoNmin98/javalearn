package com.lzy.maplearn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: lzy
 * @description: 测试
 * @date: 2020-09-21-7:52
 */
public class MapTerst {

    @Test
    public void test1(){
        Map<String,Integer> map=new HashMap<>();
        map.put("javc",12);
        map.put("yes",32);
        map.put("no",13);
        //遍历
        System.out.println(map);
        System.out.println();


        ArrayList<Integer> list=new ArrayList<Integer>();
        Collection<Integer> values=map.values();
        for(Integer i:values){
            list.add(i);
        }

        System.out.println(list);
    }


}
