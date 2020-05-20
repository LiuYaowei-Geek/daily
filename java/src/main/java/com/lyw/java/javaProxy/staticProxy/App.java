package com.lyw.java.javaProxy.staticProxy;

/**
 * 代理模式
 */
public class App {
    public static void main(String[] args) {
        SubjectProxy subjectProxy = new SubjectProxy(new SubjectImpl());
        subjectProxy.hello("666");
    }
}
