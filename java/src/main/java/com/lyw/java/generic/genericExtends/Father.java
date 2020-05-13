package com.lyw.java.generic.genericExtends;

/**
 * 泛型继承问题
 * @param <T>
 */
public class Father<T> {
    T data;

    public Father(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Father{" +
                "data=" + data +
                '}';
    }
}
