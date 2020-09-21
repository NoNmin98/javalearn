package com.lzy.filelearn;

import org.junit.Test;

import java.io.*;

/**
 * @author: lzy
 * @description: 缓冲流测试
 * @date: 2020-09-21-14:44
 */
public class BufferedTest {

    //使用用来实现非文本文件的复制。
    @Test
    public void BufferStreamTest() {
        long start=System.currentTimeMillis();

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File file = new File("bigtestimg.png");
            File file1 = new File("bigtestimg1.png");

            //2.造流
            //2.1.造节点流
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(file1);
            //2.2.造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制细节
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流，需要先关闭外层流，再关闭内存流
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //再关闭外城流的时候内层流也自动关闭了
            //fis.close();
            //fos.close();
        }
        long end=System.currentTimeMillis();

        System.out.println(end-start);//10: 58

    }
}
