package com.lzy.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * @author: lzy
 * @description: 菜单栏添加
 * @date: 2020-09-23-7:38
 */
public class SimpleMenu {

    private Frame frame=new Frame("test menu");

    //创建菜单条
    MenuBar menubar=  new  MenuBar();
    //创建菜单组件，也就是有下级菜单的
    Menu fileMenu=new Menu("file");
    Menu editMenu=new Menu("edit");
    Menu formatMenu=new Menu("format");

    //创建菜单项
    MenuItem auto=new MenuItem("自动换行");
    MenuItem copy=new MenuItem("复制");
    MenuItem paste=new MenuItem("粘贴");
    MenuItem comment=new MenuItem("注释 Ctrl+Shift+Q",new MenuShortcut(KeyEvent.VK_Q,true));
    MenuItem cancelComment=new MenuItem("取消注释");

    //创建文本框
    TextArea tf=new TextArea(6,40);

    public void init(){
        //组装，从内到外组装
        //只给注释添加功能
        comment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.append(e.getActionCommand());//这个方法返回的点击的位置的文本
            }
        });
        //组装二级菜单
        formatMenu.add(comment);
        formatMenu.add(cancelComment);
        //组装编辑菜单
        editMenu.add(auto);
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.add("-");
        editMenu.add(formatMenu);
        //组装菜单条
        menubar.add(fileMenu);
        menubar.add(editMenu);
        //把菜单条放入到frame中，有现成的方法，setMenuBar
        frame.setMenuBar(menubar);
        frame.add(tf);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleMenu().init();
    }
}
