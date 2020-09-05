package com.lzy.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @author lzy
 * @description
 * @create 2020-08-30-22:26
 */
public class BoxLayoutDemo3 {
    public static void main(String[] args) {
        Frame frame = new Frame();

        //创建水平排列的box容器
        Box hbox=Box.createHorizontalBox();
        //添加按钮，需要在多个按钮之间添加分割
        hbox.add(new Button("h1"));
        hbox.add(Box.createHorizontalGlue());//两个方向上都可以分割,
        hbox.add(new Button("h2"));
        hbox.add(Box.createHorizontalStrut(30));
        hbox.add(new Button("h3"));
        //创建垂直排列的box
        Box vbox=Box.createVerticalBox();
        //添加按钮，添加分割
        vbox.add(new Button("v1"));
        vbox.add(Box.createVerticalGlue());
        vbox.add(new Button("v2"));
        vbox.add(Box.createVerticalStrut(30));
        vbox.add(new Button("v3"));

        //放到frame中

        frame.add(hbox,BorderLayout.NORTH);
        frame.add(vbox);
        frame.pack();
        frame.setVisible(true);

    }

}
