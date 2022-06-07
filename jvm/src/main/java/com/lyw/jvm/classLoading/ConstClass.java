package com.lyw.jvm.classLoading;

public class ConstClass {
    static {
        System.out.println("const class init");
    }
    public static final String HELLO_WORLD = "hello world";
}
