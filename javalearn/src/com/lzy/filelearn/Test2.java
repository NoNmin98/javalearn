package com.lzy.filelearn;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: lzy
 * @description: 联系获取文本中每个字符出现的次数
 * @date: 2020-09-21-15:42
 */
public class Test2 {

    @Test
    public void test1(){
        FileReader fr= null;
        BufferedWriter bw= null;
        try {
            //创建存放的map数组
            HashMap<Character,Integer> map = new HashMap<>();
            //创建文件,创建流
            File file = new File("jo.txt");
            fr = new FileReader(file);
            //遍历操作
            int c=0;
            while((c=fr.read())!=-1){
                char ch= (char) c;
                //判断是否第一次出现，如果是第一次出现添加
                //if(map.get(ch)==null){
                if (map.containsKey(ch)==false){
                    map.put(ch,1);
                }else{
                    map.put(ch,map.get(ch)+1);
                }
            }

            //把数据添加到count.txt文件中
            bw = new BufferedWriter(new FileWriter(new File("count.txt")));
            //遍历map再写入数据
            Set<Map.Entry<Character,Integer>> entryset=map.entrySet();
            for (Map.Entry<Character,Integer> entry:entryset){
                switch (entry.getKey()){
                    case ' ':
                        bw.write("空格="+entry.getValue());
                        break;
                    case '\t':
                        bw.write("tab="+entry.getValue());
                        break;
                    case '\r':
                        bw.write("回车="+entry.getValue());
                        break;
                    case '\n':
                        bw.write("换行="+entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey()+"="+entry.getValue());
                        break;
                }
                //创建新的一行
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr!=null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw!=null)
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
