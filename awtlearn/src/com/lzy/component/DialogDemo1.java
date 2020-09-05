package com.lzy.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: lzy
 * @description: dialog对话框小案例，dialog中添加内容
 * @date: 2020-09-04-22:24
 */
public class DialogDemo1 {
    public static void main(String[] args) {
        Frame frame = new Frame("testdialog");

        //创建两个对话框对象模式和非模式
        Dialog d1 = new Dialog(frame, "first", true);
            //创建一个垂直的box容器，把文本框和一个按钮添加到box容器中
        Box vBox = Box.createVerticalBox();
        vBox.add(new TextField(20));
        vBox.add(new Button("confirm"));
        //box添加到dialog
        d1.add(vBox);

        //通过setBounds方法设置dialog位置和大小
        d1.setBounds(20,30,300,200);
        //创建两个按钮
        Button b1 = new Button("model");

        //添加按钮点击事件
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d1.setVisible(true);
            }
        });
        //按钮添加到frame
        frame.add(b1,BorderLayout.NORTH);

        frame.pack();
        frame.setVisible(true);

    }
}
