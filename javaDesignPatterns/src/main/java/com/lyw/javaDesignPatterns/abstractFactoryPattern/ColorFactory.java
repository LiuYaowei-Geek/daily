package com.lyw.javaDesignPatterns.abstractFactoryPattern;

public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(ColorTypeEnum colorType) {
        switch (colorType) {
            case RED:
                return new Red();
            case GREEN:
                return new Green();
            default:
                return null;
        }
    }

    @Override
    public Shape getShape(ShapeTypeEnum shapeType) {
        return null;
    }
}
