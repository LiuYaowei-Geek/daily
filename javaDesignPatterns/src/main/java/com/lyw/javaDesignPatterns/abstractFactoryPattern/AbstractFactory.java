package com.lyw.javaDesignPatterns.abstractFactoryPattern;

public abstract class AbstractFactory {

    public abstract Color getColor(ColorTypeEnum colorType);

    public abstract Shape getShape(ShapeTypeEnum shapeType);
}
