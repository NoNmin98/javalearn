package com.lzy.filelearn;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author: lzy
 * @description:
 * @date: 2020-09-19-21:13
 */
public class Person<T> implements Serializable {

    public static final long serialVersionUID = 4223453L;

    String name;
    int age;
    T orderT;

    public Person(){}

    public Person(String name, int age, T orderT){
        this.name=name;
        this.age=age;
        this.orderT=orderT;
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

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person<?> person = (Person<?>) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(orderT, person.orderT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, orderT);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", orderT=" + orderT +
                '}';
    }

}
