package com.lzy.setlearn;

import com.lzy.collectionlearn.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author: lzy
 * @description: 联系set接口
 *
 * @date: 2020-09-16-10:44
 */
public class SetLearn {
    @Test
    public void test1(){
        HashSet set = new HashSet();
        set.add(123);
        set.add(456);
        set.add("aa");
        set.add("cc");
        set.add(new Person("Tom",12));

        Iterator iter=set.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}
