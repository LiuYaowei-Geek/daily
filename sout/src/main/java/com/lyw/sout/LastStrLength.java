package com.lyw.sout;

public class LastStrLength {
    public static void lastLength(String str) {
        String[] strArray = str.split(" ");
        System.out.print(strArray[strArray.length -1].length());
    }

    public static void main(String[] args) {
        String s = "hello world";
        lastLength(s);
    }
}
