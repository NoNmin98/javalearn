package com.lzy.filelearn;

import java.io.File;
import java.io.IOException;

/**
 * @author: lzy
 * @description: 创建一个指定文件相同地址的另一个文件
 * @date: 2020-09-21-8:02
 */
public class CreateFileTest {
    public static void main(String[] args) throws IOException {
        File file1=new File("helloFile.txt");
        file1.createNewFile();

        File file2=new File(file1.getParent(),"helloTest1.txt");
        file2.createNewFile();
    }
}
