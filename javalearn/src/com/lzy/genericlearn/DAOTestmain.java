package com.lzy.genericlearn;

import java.util.HashMap;
import java.util.List;

/**
 * @author: lzy
 * @description: 用来测试DAOTest
 * @date: 2020-09-20-15:15
 */
public class DAOTestmain {
    public static void main(String[] args) {
        DAOTest<Person> dao=new DAOTest<>();
        //注意：这个地方如果直接添加数据会显示空指针异常，需要在DAO类中进行map实例化,否则在save方法中没有实例进行put操作。
        dao.setMap(new HashMap<>());

        dao.save("1",new Person("asdf",123,"ceshi"));
        dao.save("2",new Person("fdss",234,"beizhu"));

//        System.out.println(dao.list());
        List<Person> list=dao.list();
        list.forEach(System.out::println);
    }
}
