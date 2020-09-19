package com.lzy.maplearn;

import java.util.Objects;

/**
 * @author: lzy
 * @description:
 * @date: 2020-09-19-9:40
 */
public class User implements Comparable{
    private String name;
    private  int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User user=(User)o;
            int compare=-this.name.compareTo(user.name);
            if(compare!=0){
                return compare;
            }
            else{
                return Integer.compare(this.age,user.age);
            }
            }
        else{
            throw new RuntimeException("传入数值异常");
        }
    }
}
