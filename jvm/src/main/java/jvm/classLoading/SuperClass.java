package jvm.classLoading;

public class SuperClass {
    static {
        System.out.println("init super class");
    }
    public static int supperValue = 123;
}
