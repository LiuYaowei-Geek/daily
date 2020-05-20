package com.lyw.java.javaProxy.staticProxy;

public class SubjectImpl implements Subject {

    @Override
    public void hello(String param) {
        System.out.println(param);
    }
}
