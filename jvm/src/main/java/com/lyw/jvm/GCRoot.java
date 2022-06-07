package com.lyw.jvm;

/**
 * @author liuyaowei488
 * @date created in 2020-4-17 10:22
 */
public class GCRoot {
    public static GCRoot SAVE = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("execute finalize method");
        SAVE = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE = new GCRoot();
        SAVE = null;
        System.gc();
        Thread.sleep(500);

        if (SAVE != null) {
            System.out.println("alive");
        } else {
            System.out.println("dead");
        }

        System.out.println("=======================");
        SAVE = null;
        System.gc();
        Thread.sleep(500);

        if (SAVE != null) {
            System.out.println("alive");
        } else {
            System.out.println("dead");
        }
    }
}
