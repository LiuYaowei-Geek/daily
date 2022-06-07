package com.lyw.javaDesignPatterns.factoryPattern;

/**
 * 形状工厂类
 */
public class ShapeFactory {
    /**
     * 根据形状类型，返回具体的形状对象
     *
     * @param shapeType 形状类型
     * @return Shape
     * @see ShapeTypeEnum
     * @see Shape
     */
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
