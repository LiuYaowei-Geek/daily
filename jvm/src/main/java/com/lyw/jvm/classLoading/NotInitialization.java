package com.lyw.jvm.classLoading;

public class NotInitialization {

    static {
        System.out.println("init self class");
    }

    public static void main(String[] args) {
        System.out.println(SubClass.subValue);
//        SuperClass[] sca = new SuperClass[10];
//        System.out.println(ConstClass.HELLO_WORLD);
    }
}
