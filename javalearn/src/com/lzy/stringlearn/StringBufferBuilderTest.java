package com.lzy.stringlearn;

import org.junit.Test;

/**
 * @author: lzy
 * @description: compare String StringBuffer and StringBuilder
 * @date: 2020-09-06-11:31
 */
public class StringBufferBuilderTest {

    @Test
    public void test()
    {
        StringBuffer sb1=new StringBuffer("abc");
        sb1.setCharAt(0,'m');//这个会直接改变String
        System.out.println(sb1);
    }

}
