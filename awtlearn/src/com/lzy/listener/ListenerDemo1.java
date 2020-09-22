package com.lzy.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author: lzy
 * @description: 容器测试监听器
 * @date: 2020-09-21-22:54
 */
public class ListenerDemo1 {
    public static void main(String[] args) {
        Frame frame = new Frame("test container listener");
        //创建组件，也就是事件源
        TextField tf = new TextField(30);
        Choice name = new Choice();
        name.add("ni");
        name.add("hao");
        name.add("ya");

        //给文本域添加TextListener，监听内容变化
        tf.addTextListener(new TextListener(){
            @Override
            public void textValueChanged(TextEvent e) {
                String text = tf.getText();
                System.out.println("now the thing is :"+ text);
            }
        });

        //给下拉选项框添加ItemListener，监听选项变化
        name.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object item = e.getItem();
                System.out.println("now the item is:"+item);

            }
        });

        //给frame注册ContainerListener监听容器中组件的添加
        frame.addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(ContainerEvent e) {
                Component child = e.getChild();
                System.out.println("now the frame added :"+child);

            }

            @Override
            public void componentRemoved(ContainerEvent e) {

            }
        });

        //添加到frame,水平容器
        Box hBox = Box.createHorizontalBox();
        hBox.add(name);
        hBox.add(tf);
        frame.add(hBox);



        frame.pack();
        frame.setVisible(true);
    }
}
