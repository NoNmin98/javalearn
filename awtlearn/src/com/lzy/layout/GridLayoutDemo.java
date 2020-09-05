package com.lzy.layout;

import java.awt.*;

/**
 * 制作类似计算器布局
 */
public class GridLayoutDemo {
    public static void main(String[] agrs)
    {
        Frame frame=new Frame("calculator");

        //创建一个panel对象，里面存放一个TextFiled组件
        Panel p=new Panel();
        p.add(new TextField(30));
        //p.setLayout(new BorderLayout());
        //把当前Panel添加到frame的北边（注意如果没有指定则默认为BorderLayout）
        frame.add(p,BorderLayout.NORTH);
        //创建一个panel对象，并且设置布局管理器为GridLayout，用于下方数字显示(Panel默认为FlowLayout）
        Panel p1=new Panel();
        p1.setLayout(new GridLayout(3,5,4,4));
        //往panel中添加内容
        for(int i=0;i<10;i++)
        {
            p1.add(new Button(i+""));//通过拼接转换成String类型
        }
        p1.add(new Button("+"));
        p1.add(new Button("-"));
        p1.add(new Button("*"));
        p1.add(new Button("/"));
        p1.add(new Button("."));
        //把Panel添加到frame中
        frame.add(p1);

        frame.pack();
        frame.setVisible(true);

    }

}
