package com.lzy.java;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lzy
 * @description
 * @create 2020-09-01-21:24
 */
class LockTest1 implements Runnable{
    private int ticket = 100;
    //1.实例化ReentrantLock
    private ReentrantLock lock=new ReentrantLock();
    //Object obj=new Object();
    @Override
    public void run() {
        while (true) {
            try {
                //2.调用Lock（）
                lock.lock();
                synchronized (this) {
                    if (ticket > 0) {
                        System.out.println(Thread.currentThread().getName() + "卖票：" + ticket);
                        ticket--;
                    } else
                        break;
                }
            }
            finally {
                //3.解锁
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {

        LockTest1 lockTest = new LockTest1();
        Thread thread = new Thread(lockTest);
        Thread thread1 = new Thread(lockTest);
        Thread thread2 = new Thread(lockTest);
        thread.setName("窗口1");
        thread1.setName("窗口2");
        thread2.setName("窗口3");
        thread.start();
        thread1.start();
        thread2.start();

    }
}
