package com.lzy.filelearn;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author: lzy
 * @description: 随机存取文件流，做插入的小算法
 *                  这个文件流会直接栋第一个字符开始覆盖我们的文件，我们可以
 *                  通过seek方法进行文件的插入
 * @date: 2020-09-24-15:17
 */
public class RandomAccessFileTest {
    @Test//为了结构去除我们使用throws方式，异常处理应该使用try——catch
    public void test1() throws IOException {
        //确认读取的是什么文件，用什么方法读取rw表示可读可写
        RandomAccessFile raf=new RandomAccessFile("hello.txt","rw");
        //把指针调整到3的位置，我们从3这个位置插入数据
        //但是现在调用seek是为了保存3之后的所有数据
        raf.seek(3);
        //我们创建一个长度等于文件内容大小的数组，方便把需要插入的内容后面的内容存到里面
        StringBuilder stringBuilder = new StringBuilder((int) new File("hello.txt").length());
        //插入数据
        byte[] buffer=new byte[20];
        int len;
        while ((len=raf.read(buffer))!=-1){
            stringBuilder.append(new String(buffer,0,len));
        }
        //调回指针到3，开始插入数据“xyz”
        raf.seek(3);
        //转成字节写入
        raf.write("xyz".getBytes());
        //把保存到StringBuilder的数据写入到文件中
        raf.write(stringBuilder.toString().getBytes());
        raf.close();

    }

}
