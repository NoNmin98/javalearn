package com.lzy.collectionlearn;

import java.util.Objects;

/**
 * @author: lzy
 * @description: Person类
 * @date: 2020-09-14-15:01
 */
public class Person {
    private String name;
    private  int age;

    Person(){}

    public Person(String name, int age){
        name=name;
        age=age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
