package com.lyw.jvm.classLoading;

public class SubClass extends SuperClass {
    static {
        System.out.println("init sub class");
    }
    public static int subValue = 234;
}
