package com.lyw.jvm;

import com.lyw.jvm.model.Person;

/**
 * @author liuyaowei488
 * @date created in 2020-4-17 10:19
 */
public class RefrenceCount {
    public static void main(String[] args) {
        Person p1 = new Person("1");
        Person p2 = new Person("2");
        p1.setLover(p2);
        p2.setLover(p1);
    }
}
