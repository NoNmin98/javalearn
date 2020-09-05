package com.lzy.component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: lzy
 * @description: 测试FileDialog子类
 * @date: 2020-09-04-22:44
 */
public class fileDialogDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("fortestFileDialog");

        //创建两个filedialog对象
        FileDialog f1=new FileDialog(frame,"选择要打开的文件",FileDialog.LOAD);
        FileDialog f2=new FileDialog(frame,"选择要保存的路径",FileDialog.SAVE);
        //创建两个按钮
        Button b1 = new Button("open file");
        Button b2 = new Button("save file");
        //给按钮设置行为，获取&保存路径文件名
        b1.addActionListener(new ActionListener() {//这是创建一个匿名对象
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true);//这个时候弹出对话框，代码阻塞，完成相关设置后代码继续执行
                //获取选择的文件和路径
                String directory = f1.getDirectory();
                String file = f1.getFile();
                System.out.println("打开的文件路径为："+directory);
                System.out.println("打开的文件名称为："+file);

            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setVisible(true);//这个时候弹出对话框，代码阻塞，完成相关设置后代码继续执行
                //获取选择的文件和路径
                String directory = f2.getDirectory();
                String file = f2.getFile();
                System.out.println("保存的文件路径为："+directory);
                System.out.println("保存的文件名称为："+file);
            }
        });
        //按钮添加到frame中
        frame.add(b1);
        frame.add(b2,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}
