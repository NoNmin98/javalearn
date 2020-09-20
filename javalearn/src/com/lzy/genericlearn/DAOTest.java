package com.lzy.genericlearn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author: lzy
 * @description: 自定义泛型的类
 * @date: 2020-09-20-14:49
 */
public class DAOTest<T> {
    private Map<String,T> map;

    public Map<String, T> getMap() {
        return map;
    }

    public void setMap(Map<String, T> map) {
        this.map = map;
    }

    public void save(String id, T th){
        map.put(id,th);
    }

    public List<T> list(){

        //错误的,map无序，但是List有序。
        //强转需要首先这个数据是这个类型本身然后在转换回来。
        /*Collection<T> values=map.values();
        return (List<T>) values;*/
        //正确的
        ArrayList<T> list=new ArrayList<>();
        Collection<T> values=map.values();
        for(T t : values){
            list.add(t);
        }
        return list;
    }
}
