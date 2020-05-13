package com.lyw.java.generic.genericExtends;

public class Son6<T> extends Father<Integer> {

    T specialDate;

    public Son6(Integer data, T specialDate) {
        super(data);
        this.specialDate = specialDate;
    }
}
