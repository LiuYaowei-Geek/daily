package com.lyw.javaDesignPatterns.singletonPattern;

public class SingleObject {

    private SingleObject() {}

    private static SingleObject instance = new SingleObject();

    public static SingleObject getInstance() {
        return instance;
    }

    public void show() {
        System.out.println("singleton pattern");
    }

}
