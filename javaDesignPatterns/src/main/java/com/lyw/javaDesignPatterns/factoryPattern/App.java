package com.lyw.javaDesignPatterns.factoryPattern;

public class App {

    public static void main(String[] args) {
        //创建工厂
        ShapeFactory factory = new ShapeFactory();
        //实例1
        Shape shape1 = factory.getShape(ShapeTypeEnum.RECTANGLE);
        shape1.draw();
        //实例2
        Shape shape2 = factory.getShape(ShapeTypeEnum.SQUARE);
        shape2.draw();
    }
}
