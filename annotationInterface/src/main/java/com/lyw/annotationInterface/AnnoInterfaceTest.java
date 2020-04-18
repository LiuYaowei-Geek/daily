package com.lyw.annotationInterface;

/**
 * @author liuyaowei488
 * @date created in 2019-12-13 15:38
 */
public class AnnoInterfaceTest {
    public static void main(String[] args) {
        Statudent statudent = new Statudent();
        statudent.setSex("77");
        String msg = Validator.validate(statudent);
        System.out.println(msg);
    }
}
