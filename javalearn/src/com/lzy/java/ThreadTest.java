package com.lzy.java;

/**
 * @author lzy
 * @description
 * @create 2020-08-31-21:07
 */

class MyThread extends Thread{
    //重启run方法
    @Override
    public void run() {
        super.run();
        for (int i=0;i<100;i++)
        {
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
