package com.lzy.layout;

import java.awt.*;

public class BorderLayoutDemo1 {
    public static void main(String[] agrs)
    {
        Frame frame=new Frame("testBorderLayout");

        //给frame设置BorderLayout布局管理器
        frame.setLayout(new BorderLayout(30,10));
        //向frame指定区域添加组件
        //frame.add(new Button("northButton"),BorderLayout.NORTH);
        frame.add(new Button("southButton"),BorderLayout.SOUTH);
        //frame.add(new Button("eastButton"),BorderLayout.EAST);
        frame.add(new Button("westButton"),BorderLayout.WEST);
        frame.add(new Button("centerButton"),BorderLayout.CENTER);
        /*当在同一个区域添加多个组件的时候，后面的组件覆盖前面的组件导致只能看到最后组件
        BorderLayout会把区域分为五个，如果其他区域没有被调用，则其位置会被center占用
        */
        frame.add(new TextField("testTextField"));
        //最佳大小
        frame.pack();
        frame.setVisible(true);
    }
}
