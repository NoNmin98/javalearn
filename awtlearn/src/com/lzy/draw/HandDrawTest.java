package com.lzy.draw;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * @author: lzy
 * @description: 完成一个手绘的案例
 * @date: 2020-09-25-16:07
 */
public class HandDrawTest {
    private Frame frame =new Frame();
    //定义画图区域的长宽
    private final int AREA_WIDTH=500;
    private final int AREA_HEIGHT=400;
    //定义右键菜单，用来设置画笔的颜色
    private PopupMenu colorMenu=new PopupMenu();
    private MenuItem redItem=new MenuItem("red");
    private MenuItem greenItem=new MenuItem("green");
    private MenuItem blueItem=new MenuItem("blue");
    private MenuItem blackItem=new MenuItem("black");
    private Color forceColor=Color.BLACK;

    //创建一个BufferedImage位图对象，第三个参数设置图片的类别
    //这个是否可以看做是画出来的画？
    BufferedImage image=new BufferedImage(AREA_WIDTH,AREA_HEIGHT,BufferedImage.TYPE_3BYTE_BGR);
    //通过位图，获取关联的Graphics对象
    //这里我们把画获取，之后需要放到画布上
    Graphics g=image.getGraphics();

    //自定义一个类，继承Canvas
    private class MyCanvas extends Canvas{

        @Override
        public void paint(Graphics g) {
            g.drawImage(image,0,0,null);
        }
    }
    //对这个画布实例化
    MyCanvas drawArea=new MyCanvas();

    //定义变量，


    public void init(){
        //组装视图，逻辑控制

        //事件监听器，更换颜色
        ActionListener listener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //需要获取到右键点击的内容使用getActionCommand
                String actionCommand = e.getActionCommand();
                switch (actionCommand){
                    case "red":
                        forceColor=Color.red;
                        break;
                    case  "green":
                        forceColor=Color.green;
                        break;
                    case "blue":
                        forceColor= Color.blue;
                        break;
                    case "black":
                        forceColor=Color.BLACK;
                        break;
                    default:
                        forceColor=Color.BLACK;
                }

            }
        };
        redItem.addActionListener(listener);
        greenItem.addActionListener(listener);
        blueItem.addActionListener(listener);
        blackItem.addActionListener(listener);
        //菜单项添加到菜单中：
        colorMenu.add(redItem);
        colorMenu.add(greenItem);
        colorMenu.add(blueItem);
        colorMenu.add(blackItem);
        //把colorMenu设置给绘图区域，表示在这个区域里可以使用colorMenu
        drawArea.add(colorMenu);
        //设置drawArea的监听器,鼠标抬起时
        drawArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                boolean popupTrigger = e.isPopupTrigger();
                if (popupTrigger){
                    colorMenu.show(drawArea,e.getX(),e.getY());
                }
            }
        });

        //设置位图的背景为白色,填充
        g.setColor(Color.white);
        g.fillRect(0,0,AREA_WIDTH,AREA_HEIGHT);
        drawArea.addMouseListener(new MouseAdapter() {
            //该方法：当鼠标左键按下并且拖动的时候会被调用
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }
        });

        //frame.add();
        frame.pack();
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        new HandDrawTest().init();
    }
}
