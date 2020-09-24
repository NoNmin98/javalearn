package com.lzy.draw;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: lzy
 * @description: 测试绘图
 * @date: 2020-09-23-9:14
 */
public class SimpleDrawTest {
    //创建组件
    private final String RECT_SHAPE="rect";
    private final String OVAL_SHAPE="oval";
    //定义一个变量，记录当前要绘制的图形,上述的常量用来给shape赋值
    private String shape="";

    private Frame frame=new Frame();

    Button btnr=new Button("绘制矩形");
    Button btno=new Button("绘制椭圆");
    //画图需要的操作
    //自定义类：继承Canvas类，重写paint方法，完成画图,这里相当于你直接定义好了怎么画图
    private class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            //绘制不同的图形
            if (shape.equals(RECT_SHAPE)){
                //绘制矩形
                g.setColor(Color.BLACK);
                //g.drawRect(100,100,150,200);
                g.draw3DRect(100,100,100,200,false);
            }else{
                //绘制椭圆形
                g.setColor(Color.CYAN);
                g.drawOval(100,100,140,190);
            }
        }
    }

    //创建自定义的画布对象,创建画画的地方
    MyCanvas mc=new MyCanvas();

    public void init(){
        //组装视图
        btnr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //修改标记的值为rect
                shape=RECT_SHAPE;
                //这个时候是没有任何对象的，我们需要重写绘制图形才能显示
                mc.repaint();
            }
        });
        btno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape=OVAL_SHAPE;
                mc.repaint();
            }
        });
        //创建panel承载按钮
        Panel panel = new Panel();
        panel.add(btnr);
        panel.add(btno);
        frame.add(panel, BorderLayout.SOUTH);

        //设置drawAread的大小
        mc.setPreferredSize(new Dimension(400,400));
        frame.add(mc);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new SimpleDrawTest().init();
    }
}
