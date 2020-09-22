package com.lzy.listener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author: lzy
 * @description: 测试WindowListener
 * @date: 2020-09-22-8:23
 */
public class WindowListenerDemo1 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setBounds(200,200,500,300);

        //设置windowlistener，监听点击X的动作，若果点击，就关闭窗口
        //frame.addWindowListener(new WindowListener()这样需要重写非常多非方法
        //所以我们可以使用适配器设计模式，需要重写什么就重写什么
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //停止当前窗口
                System.exit(0);
            }
        });

        frame.setVisible(true);

    }
}
