package com.lzy.java;

/**
 * @author lzy
 * @description 线程通信的例子，使用两个线程打印1-100.线程1,2交替打印
 * 线程1wait之后释放锁，线程2进入获得锁，notify唤醒线程1但是，
 * 此时1没有获得锁无法执行，线程2到wait之后释放锁，线程1继续，实现交替
 * @create 2020-09-01-22:26
 */

class Number implements Runnable{
    private int number=1;
    @Override
    public void run() {
        while (true)
        {
            synchronized (this){

                //唤醒线程.
                notify();

                if(number<=100){
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;

                    //调用wait方法的线程阻塞
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();

        Thread thread = new Thread(number);
        Thread thread1 = new Thread(number);
        thread.setName("线程1");
        thread1.setName("线程2");
        thread.start();
        thread1.start();
    }
}
