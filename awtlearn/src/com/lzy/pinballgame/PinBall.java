package com.lzy.pinballgame;

import java.awt.*;
import java.awt.event.*;

/**
 * @author: lzy
 * @description: 弹球小游戏Demo
 * @date: 2020-09-23-10:01
 */
public class PinBall {
    //创建frame，确定常量大小
    Frame frame = new Frame("pinball game demo");
    private final int TABLE_WIDTH = 300;
    private final int TABLE_HEIGHT = 400;
    private final int RACKET_WIDTH = 80;
    private final int RACKET_HEIGHT = 20;
    private final int BALL_SIZE = 15;
    //定义变量记录小球的坐标
    private int ballX = 120;
    private int ballY = 20;
    //定义小球在想，要，方向上的移动速度
    public int speedup=0;
    private int speedX = 5;
    private int speedY = 5;
    //定义球拍的初始化坐标
    private int racketX = 120;
    private final int racketY = 340;
    //定义变量是否当前游戏已经结束
    private boolean isOver = false;
    //声明一个定时器
    private javax.swing.Timer timer;
    public int sum=0;




    //自定义类，继承canvas当画布
    private class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            //在这里绘制内容
            //游戏结束,绘制结束画面
            if (isOver) {
                //mc.repaint();
                g.setColor(Color.BLUE);
                g.setFont(new Font("Times", Font.BOLD, 30));
                g.drawString("Game Over", 50, 200);
            }
            //游戏中
            //绘制小球
            g.setColor(Color.red);
            g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
            //绘制球拍
            g.setColor(Color.gray);
            g.fillRect(racketX, racketY, RACKET_WIDTH, RACKET_HEIGHT);

            g.setColor(Color.cyan);
            g.drawString("fenshu:"+sum,0,TABLE_HEIGHT-10);
            g.drawString("nandu:"+speedup,60,TABLE_HEIGHT-10);
        }
    }

    //创建绘制区域，实例化我们的自定义类
    MyCanvas mc = new MyCanvas();


    public void init() {
        //组装视图和游戏逻辑
        //完成球拍坐标的变换
        KeyListener kl = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //所有键盘上的案件都可以通过int来获取
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_LEFT) {
                    //向左移动，但是我们不能移动出去了。所以需要判断
                    if (racketX > 0) {
                        racketX -= 10;
                    }

                }
                if (keyCode == KeyEvent.VK_RIGHT) {
                    //向右移动，但是需要注意的是，我们的定点是在左上角，在确认是否到达便捷的时候要加上球拍长度
                    if (racketX + RACKET_WIDTH < TABLE_WIDTH) {
                        racketX += 10;
                    }

                }

            }
        };
        //注册监听,两个都可以作为事件源，为了保证可以被监听到我们把两个都注册监听
        frame.addKeyListener(kl);
        mc.addKeyListener(kl);

        //小球坐标的控制
        //创建监听器
        ActionListener ballListener= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //更新小球坐标，重绘界面
                //首先判断x坐标,修正速度
                if(ballX<=0 || ballX+BALL_SIZE>TABLE_WIDTH){
                    speedX=-speedX;
                }
                if (ballY<=0 || (ballY+BALL_SIZE>racketY && ballX>racketX && ballX<racketX+RACKET_WIDTH)){
                    speedY=-speedY;
                }
                if (ballY+BALL_SIZE>racketY &&(ballX<racketX || ballX>racketX+RACKET_WIDTH)){
                    timer.stop();
                    isOver=true;
                    mc.repaint();
                }
                if(ballY+BALL_SIZE>=racketY){
                    sum++;
                    speedup++;
                }

                ballX+=speedX;
                ballY+=speedY;
                mc.repaint();
            }
        };

        //定时器，多久执行一次，每隔这个时间执行的代码是什么
        //timer = new Timer(50, ballListener);
        timer=new javax.swing.Timer(50, ballListener);
        timer.start();

        mc.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));
        frame.add(mc);

        frame.pack();
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        new PinBall().init();
    }
}
