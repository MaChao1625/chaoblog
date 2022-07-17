package cn.itcast.web.test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        String str ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwsyz1234567890";
        Random ran = new Random();
        int index = ran.nextInt(str.length());
        System.out.println(str.length());
        System.out.println(index);
        //charAt()返回字符的索引。
        char ch = str.charAt(index);
        System.out.println(ch);
    }
}
