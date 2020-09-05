package com.lzy.layout;

import java.awt.*;

public class BorderLayoutDemo {
    public static void main(String[] agrs)
    {
        Frame frame=new Frame("testBorderLayout");

        //给frame设置BorderLayout布局管理器
        frame.setLayout(new BorderLayout(30,10));
        //向frame指定区域添加组件
        frame.add(new Button("northButton"),BorderLayout.NORTH);
        frame.add(new Button("southButton"),BorderLayout.SOUTH);
        frame.add(new Button("eastButton"),BorderLayout.EAST);
        frame.add(new Button("westButton"),BorderLayout.WEST);
        frame.add(new Button("centerButton"),BorderLayout.CENTER);
        //最佳大小
        frame.pack();
        frame.setVisible(true);
    }
}
