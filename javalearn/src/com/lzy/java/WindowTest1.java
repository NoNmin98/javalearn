package com.lzy.java;

/**
 * 卖100张票，三个窗口一起卖,使用实现Runnable接口的方式
 *和上一个创建线程的方式不同的是，这个方式创建的线程因为只创建了一个Window1实例导致共用一个ticket
 * 无需额外加ticket为static
 * 线程安全问题没有解决
 *
 * @author lzy
 * @description
 * @create 2020-09-01-16:26
 */

class Window1 implements Runnable {
    private int ticket = 100;
    Object obj=new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖票：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {

        Window1 window1 = new Window1();
        Thread thread = new Thread(window1);
        Thread thread1 = new Thread(window1);
        Thread thread2 = new Thread(window1);
        thread.setName("窗口1");
        thread1.setName("窗口2");
        thread2.setName("窗口3");
        thread.start();
        thread1.start();
        thread2.start();

    }
}
