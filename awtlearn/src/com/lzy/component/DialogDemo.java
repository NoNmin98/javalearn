package com.lzy.component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: lzy
 * @description: dialog对话框小案例
 * 模式对话框：子对话框出现后不能操作父对话框（例如在配置环境变量时不能拖动其父类对话框
 * 非模式对话框：可以直接操作父类
 * @date: 2020-09-04-22:24
 */
public class DialogDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("testdialog");

        //创建两个对话框对象模式和非模式
        Dialog d1 = new Dialog(frame, "first", true);
        Dialog d2 = new Dialog(frame, "second", false);
        //通过setBounds方法设置dialog位置和大小
        d1.setBounds(20,30,300,200);
        d2.setBounds(20,30,300,200);
        //创建两个按钮
        Button b1 = new Button("model");
        Button b2 = new Button("non-model");

        //添加按钮点击事件
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d1.setVisible(true);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d2.setVisible(true);
            }
        });
        //按钮添加到frame
        frame.add(b1,BorderLayout.NORTH);
        frame.add(b2);

        frame.pack();
        frame.setVisible(true);

    }
}
