package com.lyw.javaDesignPatterns.singletonPattern;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        SingleObject singleObject = SingleObject.getInstance();
        singleObject.show();
    }
}
