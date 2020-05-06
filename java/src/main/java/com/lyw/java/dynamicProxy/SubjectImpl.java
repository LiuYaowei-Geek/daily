package com.lyw.java.dynamicProxy;

/**
 * @author liuyaowei488
 * @date created in 2020-4-17 12:15
 */
public class SubjectImpl implements Subject {
    @Override
    public void hello(String param) {
        System.out.println(String.format("hello: %s", param));
    }
}
