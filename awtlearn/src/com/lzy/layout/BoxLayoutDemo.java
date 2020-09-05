package com.lzy.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @author lzy
 * @description
 * @create 2020-08-27-23:14
 */
public class BoxLayoutDemo {
    public static void main(String[] args) {
        Frame frame=new Frame("testBoxLayout");

//        基于frame，创建一个BoxLayout对象，并且，改对象是垂直存放
        BoxLayout boxLayout=new BoxLayout(frame,BoxLayout.X_AXIS);
//        把BoxLayout对象设置给Frame
        frame.setLayout(boxLayout);

//        往frame中添加两个按钮组件
        frame.add(new Button("b1"));
        frame.add(new Button("b2"));
        frame.pack();
        frame.setVisible(true);
    }

}
