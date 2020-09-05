package com.lzy.javatest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: lzy
 * @description: 第三种方式创建线程 ，实现Calable接口。
 * @date: 2020-09-04-15:34
 */
//创建一个callable实现类
class NumThread implements Callable{
//实现call方法
    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}

public class Thread3th {
    public static void main(String[] args) {
        //创建实现类对象
        NumThread numThread=new NumThread();
        //实现类的对象床底到FutureTask类中作为参数，创建FutureTask对象
        FutureTask futureTask=new FutureTask(numThread);
        //缺少这一句就无法启动线程
        new Thread(futureTask).start();
        //输出结果
        try {
            Object sum=futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
