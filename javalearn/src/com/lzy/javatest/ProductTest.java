package com.lzy.javatest;

/**
 * @author: lzy
 * @description: 生产者消费者问题商店最多：0
 * @date: 2020-09-04-9:59
 */

class Clerk{//店员

    private int productCount=0;

    public synchronized void produceProduct() {
        if(productCount<20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+":开始生产产品:"+productCount);
            //只要生产了一个产品就可以开始消费了
            notify();
        }
        else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() {
        if (productCount>0)
        {
            System.out.println(Thread.currentThread().getName()+":开始消费产品:"+ productCount);
            productCount--;
            //只要消费了一个产品就可以开始生产了，基础阻塞
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{//生产者
    private Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+"开始生产产品");
        while (true){
            clerk.produceProduct();
        }
    }
}

class Consumer extends Thread{//消费者
    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+"开始消费产品");
        while (true){
            clerk.consumeProduct();
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();
        Producer p1=new Producer(clerk);
        p1.setName("生产者1：");
        Consumer c1=new Consumer(clerk);
        c1.setName("消费者1：");
        p1.start();
        c1.start();
    }
}
