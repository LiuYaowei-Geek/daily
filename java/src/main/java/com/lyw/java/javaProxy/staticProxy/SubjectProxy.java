package com.lyw.java.javaProxy.staticProxy;

public class SubjectProxy implements Subject {

    private Subject subject;

    public SubjectProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void hello(String param) {
        subject.hello(param);
    }
}
