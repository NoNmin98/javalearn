package com.lzy.layout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author lzy
 * @description for test CardLayout
 * @create 2020-08-26-21:29
 */
public class CardLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("for test CardLayout");

        //主体
//        创建一个Panel，存储多个卡片
        Panel p1 = new Panel();
//        创建CardLayout对象，并且把改对象设置给之前创造的容器
        CardLayout cardlayout = new CardLayout();
        p1.setLayout(cardlayout);
//        往Panel中存储多个组件
        String[] names = {"first", "second", "3", "4", "5"};
        for (int i = 0; i < names.length; i++) {
            p1.add(names[i], new Button(names[i]));
        }
//        把panel方法frame中间区域
        frame.add(p1,BorderLayout.CENTER);
//        创建另一个Panel，p2存储多个按钮组件
        Panel p2=new Panel();
//        创建五个按钮组件
        Button b1= new Button("preCard");
        Button b2= new Button("nextCard");
        Button b3= new Button("firstCard");
        Button b4= new Button("lastCard");
        Button b5= new Button("thirdCard");
//        创建一个事件监听器，监听点击动作
        ActionListener listener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand=e.getActionCommand();//获取按钮上的字符
                switch (actionCommand)
                {
                    case "preCard":
                        cardlayout.previous(p1);
                        break;
                    case "nextCard":
                        cardlayout.next(p1);
                        break;
                    case "firstCard":
                        cardlayout.first(p1);
                        break;
                    case "lastCard":
                        cardlayout.last(p1);
                        break;
                    case "thirdCard":
                        cardlayout.show(p1,"3");
                        break;
                }
            }
        };
//        把事件监听器绑定到按钮
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);
//        按钮添加到p2
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);

//        把p2放到frame南边
        frame.add(p2,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}
