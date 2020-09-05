package com.lzy.java;

/**
 * @author lzy
 * @description 线程安全的懒汉式单例模式
 * @create 2020-09-01-20:38
 */
public class BankTest {
}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    //因为是静态的方法，所以这个锁是Bank类本身
    //效率稍差
    /*public static synchronized Bank getInstance(){
        if(instance==null)
            instance=new Bank();
        return instance;
    }*/
    public static  Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class){
                if(instance==null)
                    instance =new Bank();
            }

        }
        return instance;
    }
}
