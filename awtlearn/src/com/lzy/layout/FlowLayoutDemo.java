package com.lzy.layout;

import java.awt.*;

public class FlowLayoutDemo {
    public static void main(String[] agrs)
    {
        Frame frame=new Frame("测试流式布局");

        //通过setLayout方式设置容器的布局管理器
        frame.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
        //添加多个按钮到frame
        for(int i=0;i<100;i++)
        {
            frame.add(new Button("按钮"+i));
        }
        //设置最佳大小，pack方法
        frame.pack();
        //

        frame.setVisible(true);

    }
}
