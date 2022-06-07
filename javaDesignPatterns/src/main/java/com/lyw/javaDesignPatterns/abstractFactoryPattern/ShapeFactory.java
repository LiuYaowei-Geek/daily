package com.lyw.javaDesignPatterns.abstractFactoryPattern;

public class ShapeFactory extends AbstractFactory {

    @Override
    public Color getColor(ColorTypeEnum colorType) {
        return null;
    }

    @Override
    public Shape getShape(ShapeTypeEnum shapeType) {
        switch (shapeType) {
            case RECTANGLE:
                return new Rectangle();
            case SQUARE:
                return new Square();
            default:
                return null;
        }
    }
}
