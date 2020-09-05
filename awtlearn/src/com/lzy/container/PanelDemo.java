package com.lzy.container;

import java.awt.*;

public class PanelDemo {
    public static void main(String[] agrs)
    {
        //panel和其他容器不能单独存在，只能依附于window存在，先创建一个window

        Frame frame=new Frame("演示panel");
        //创建一个panel对象
        Panel p=new Panel();

        //创建一个文本框和按钮，并且把他们放到panel容器中
        p.add(new TextField("测试文本"));
        p.add(new Button("测试按钮"));
        //吧panel放到window中
        frame.add(p);
        //设置window位置大小
        frame.setBounds(100,100,300,500);
        //window可见
        frame.setVisible(true);
    }
}
