package com.lyw.java.javaProxy.cglibProxy;

public class App {
    public static void main(String[] args) {
        SubjectImpl subject = new SubjectImpl();
        SubjectImpl object = (SubjectImpl) new SubjectProxy(subject).getProxyInstance();
        object.hello("666");
    }
}
