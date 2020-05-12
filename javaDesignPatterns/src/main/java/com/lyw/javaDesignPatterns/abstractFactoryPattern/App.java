package com.lyw.javaDesignPatterns.abstractFactoryPattern;

public class App {
    public static void main(String[] args) {
        FactoryProducer factoryProducer1 = new FactoryProducer();

        AbstractFactory abstractFactory1 = factoryProducer1.getFactory(FactoryTypeEnum.SHAPE);
        Shape shape = abstractFactory1.getShape(ShapeTypeEnum.RECTANGLE);
        shape.draw();

        AbstractFactory abstractFactory2 = factoryProducer1.getFactory(FactoryTypeEnum.COLOR);
        Color color = abstractFactory2.getColor(ColorTypeEnum.GREEN);
        color.fill();
    }
}
