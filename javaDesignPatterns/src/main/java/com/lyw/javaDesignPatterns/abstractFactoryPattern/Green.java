package com.lyw.javaDesignPatterns.abstractFactoryPattern;

public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("fill with green");
    }
}
