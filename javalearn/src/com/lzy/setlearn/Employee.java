package com.lzy.setlearn;

/**
 * @author: lzy
 * @description:
 * @date: 2020-09-16-14:27
 */
public class Employee implements Comparable{
    private String name;
    private  int age;
    private MyDate birthday;

    public Employee(){}

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee){
            Employee e=(Employee)o;
            return this.name.compareTo(e.name);
        }
        else{
            throw new RuntimeException("error");
        }
    }
}
