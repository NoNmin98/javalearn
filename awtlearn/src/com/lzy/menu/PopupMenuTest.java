package com.lzy.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author: lzy
 * @description: 测试右键显示菜单
 * @date: 2020-09-23-8:01
 */
public class PopupMenuTest {
    private Frame frame=new Frame();
    //创建popupMenu
    PopupMenu pm=new PopupMenu();
    //创建菜单项
    MenuItem comment=new MenuItem("comment");
    MenuItem cancelComment=new MenuItem("cancelComment");
    MenuItem copy=new MenuItem("copy");
    MenuItem save=new MenuItem("save");
    //创建文本框
    TextArea ta=new TextArea("woaizhognguo",6,40);
    //创建容器
    Panel panel=new Panel();


    public void init(){
        //创建监听器，方便右键的时候能够知道我们点击的是哪个按钮
        ActionListener actionListener= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append(e.getActionCommand());
            }
        };
        //创建完了监听器，饿哦们需要注册监听，让右键产生的按钮知道我们使用的是哪个按钮
        comment.addActionListener(actionListener);
        cancelComment.addActionListener(actionListener);
        copy.addActionListener(actionListener);
        save.addActionListener(actionListener);


        //添加菜单项到菜单中
        pm.add(comment);
        pm.add(cancelComment);
        pm.add(copy);
        pm.add(save);
        panel.add(pm);
        //设置panel的大小
        //panel.setBounds(0,0,200,200);
        panel.setPreferredSize(new Dimension(400,300));

        //panel注册鼠标事件，监听用户释放鼠标的动作，展示菜单
        //注意这个地方我们是只能在panel中点击右键展示
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                //这个方法是用来判断是否是右键释放
                boolean popupTrigger = e.isPopupTrigger();
                if (popupTrigger){
                    //这里有三个参数，第一个参数表示的是属于什么源，后面为坐标
                    pm.show(panel,e.getX(),e.getY());
                }
            }
        });

        frame.add(ta);
        frame.add(panel,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PopupMenuTest().init();
    }
}
