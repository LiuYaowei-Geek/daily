package com.lyw.java.generic.genericExtends;

public class Son2<K, T> extends Father<T> {
    K specialData;

    public Son2(T data, K specialData) {
        super(data);
        this.specialData = specialData;
    }

}
