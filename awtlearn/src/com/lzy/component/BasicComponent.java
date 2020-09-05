package com.lzy.component;

import javax.swing.*;
import java.awt.*;

/**
 * @author lzy
 * @description
 * @create 2020-08-30-22:44
 */
public class BasicComponent {
    Frame frame=new Frame("basiccomponent");
    //创建组件
    //创建文本框
    TextArea ta=new TextArea(5,30);
    //下拉选择框
    Choice ch=new Choice();
    //创建单选
    CheckboxGroup cbg=new CheckboxGroup();
    Checkbox male=new Checkbox("male",cbg,true);
    Checkbox female=new Checkbox("female",cbg,false);
    //创建多选
    Checkbox isMarried=new Checkbox("ismarried?");
    //单行文本框,和确认按钮
    TextField tf=new TextField(50);
    Button ok=new Button("yes");
    //列表框
    List colorList=new List(6,true);
    //方法,组装
    public void init()
    {
        //组装底部
        Box bbox=Box.createHorizontalBox();
        bbox.add(tf);
        bbox.add(ok);
        frame.add(bbox, BorderLayout.SOUTH);

        //组装左上角的下部分选择部分
            //需要先在下拉选择框中放入文本
        ch.add("red");
        ch.add("blue");
        ch.add("green");
        Box cBox=Box.createHorizontalBox();
        cBox.add(ch);
        cBox.add(male);
        cBox.add(female);
        cBox.add(isMarried);

        //组装文本域和选择部分

        Box topLeft=Box.createVerticalBox();
        topLeft.add(ta);
        topLeft.add(cBox);
        //组装顶部左边，和列表框
            //添加列表框信息
        colorList.add("red");
        colorList.add("blue");
        colorList.add("green");

        Box top=Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);

        frame.add(top);
        //设置最佳大小
        frame.pack();
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        //调用方法
        new BasicComponent().init();
    }

}
