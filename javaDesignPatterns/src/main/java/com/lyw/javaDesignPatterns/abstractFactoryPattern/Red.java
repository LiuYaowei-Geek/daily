package com.lyw.javaDesignPatterns.abstractFactoryPattern;

public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("fill with red");
    }
}
