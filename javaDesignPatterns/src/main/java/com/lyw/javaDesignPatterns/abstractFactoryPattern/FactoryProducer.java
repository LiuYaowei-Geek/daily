package com.lyw.javaDesignPatterns.abstractFactoryPattern;

public class FactoryProducer {

    public AbstractFactory getFactory(FactoryTypeEnum factoryType) {
        switch (factoryType) {

            case SHAPE:
                return new ShapeFactory();
            case COLOR:
                return new ColorFactory();
            default:
                return null;
        }
    }
}
