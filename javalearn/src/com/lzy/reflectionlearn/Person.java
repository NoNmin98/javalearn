package com.lzy.reflectionlearn;

/**
 * @author: lzy
 * @description: 创县一个Person类进行联系,为了测试反射，我们修改一下权限
 * @date: 2020-09-24-19:24
 */
public class Person {
    private String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show(){
        System.out.println("你好我是一个人");
    }

    private String showNation(String nation){
        System.out.println("我的国际是："+nation);
        return nation;
    }

}
