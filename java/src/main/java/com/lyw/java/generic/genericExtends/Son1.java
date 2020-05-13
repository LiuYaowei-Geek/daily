package com.lyw.java.generic.genericExtends;

public class Son1<T> extends Father<T> {
    public Son1(T data) {
        super(data);
    }

    @Override
    public String toString() {
        return "Son1{" +
                "data=" + data +
                "} " + super.toString();
    }
}
