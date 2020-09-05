package com.lzy.container;

import java.awt.*;

public class ScrollPaneDemo {
    public static void main(String[] agrs)
    {
        //创建一个窗口对象
        Frame frame=new Frame("测试滚动窗口对象");
        //创建ScrollPane对象
        ScrollPane sp=new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        //在ScrollPane加内容
        sp.add(new TextField("测试文本"));
        sp.add(new Button("这是测试按钮"));
        //添加到frame
        frame.add(sp);
        //指定位置，大小
        frame.setBounds(100,100,300,500);
        //设置窗口对象课件
        frame.setVisible(true);

    }
}
