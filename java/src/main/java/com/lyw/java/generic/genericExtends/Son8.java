package com.lyw.java.generic.genericExtends;

public class Son8<K extends T, T> extends Father<T> {
    K specialData;

    public Son8(T data, K specialData) {
        super(data);
        this.specialData = specialData;
    }
}
