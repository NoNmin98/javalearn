package com.lzy.java;

/**
 * 卖100张票，三个窗口一起卖,使用继承Thread类的方式实现
 * @author lzy
 * @description
 * @create 2020-09-01-15:57
 */

class Window extends Thread{
    private static int ticket=100;

    @Override
    public void run() {
        while(true)
        {
            if(ticket>0){
                System.out.println(getName()+":买票，票号为"+ticket);
                ticket--;
            }
            else{
                break;
            }
        }
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window w1=new Window();
        Window w2=new Window();
        Window w3=new Window();

        w1.start();
        w2.start();
        w3.start();
    }
    }

