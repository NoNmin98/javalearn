package com.lzy.javatest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: lzy
 * @description:创建线程第四种方法-线程池
 * @date: 2020-09-04-15:56
 */

class NumberThread implements Runnable{

    @Override
    public void run() {
        System.out.println("启动NumberThread线程");
    }
}

public class Thread4th {
    public static void main(String[] args) {
        //制造一个线程池
       ExecutorService service= Executors.newFixedThreadPool(10);
       //设置线程池的属性
        //注意这里需要强转为ThreadPoolExecutor类型，因为ExecutorService是一个接口
        ThreadPoolExecutor service1=(ThreadPoolExecutor)service;
        service1.setCorePoolSize(15);
        //创建一个实现类和其对象，根据实现不同使用不同的方法调用线程
       service.execute(new NumberThread());//适合Runnable
       //service.submit();//适合Callable
        //关闭连接处
        service.shutdown();
    }
}
