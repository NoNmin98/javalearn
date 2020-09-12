package com.lzy.listener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: lzy
 * @description: 测试事件处理
 * @date: 2020-09-07-18:58
 */
public class EventDemo1 {
    Frame frame=new Frame();

    TextField tf=new TextField(30);
    //事件源
    Button bu=new Button("ok");

    public void init(){
        //组装视图，监听器
        MyListener myListener = new MyListener();
        //注册监听
        bu.addActionListener(myListener);
        //tf和按钮放入frame
        frame.add(tf,BorderLayout.NORTH);
        frame.add(bu);

        frame.pack();
        frame.setVisible(true);
    }

    //设置单击事件
    private class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            tf.setText("hello");
        }
    }

    public static void main(String[] args) {
        new EventDemo1().init();
    }
}
