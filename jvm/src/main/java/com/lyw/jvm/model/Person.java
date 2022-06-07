package com.lyw.jvm.model;

/**
 * @author liuyaowei488
 * @date created in 2020-4-17 10:19
 */
public class Person {

    private String name;

    private Person lover;

    public Person getLover() {
        return lover;
    }

    public void setLover(Person lover) {
        this.lover = lover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }
}
