package com.lzy.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @author lzy
 * @description
 * @create 2020-08-27-23:35
 */
public class BoxLayoutDemo1 {
    public static void main(String[] args) {
        Frame frame=new Frame();

//        创建一个水平排列的组件Box容器
        Box hBox=Box.createHorizontalBox();
//        往容器添加按钮
        hBox.add(new Button("hori1"));
        hBox.add(new Button("hori2"));
//        创建一个垂直排列的Box组件容器
        Box vBox=Box.createVerticalBox();
//        添加按钮
        vBox.add(new Button("ver1"));
        vBox.add(new Button("ver2"));
//        把Box容器放到Frame中展示
        frame.add(hBox,BorderLayout.NORTH);
        frame.add(vBox);

        frame.pack();
        frame.setVisible(true);
    }
}
