package com.lyw.java.generic.fakeGeneric;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 证明java中泛型为假泛型
 */
public class FakeGeneric {
    /**
     * 证明java中泛型为假泛型
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        //添加类型为String时会报错
//        list.add("str");

        //使用反射添加String类型
        list.add(1);
        Method add = list.getClass().getMethod("add", Object.class);//会抛出NoSuchMethodException
        add.invoke(list, "str");
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.get(1).getClass().getSimpleName());//会抛出ClassCastException
    }

    /**
     * 类型擦除
     * Java 的泛型仅仅在编译期有效，在运行期则会被擦除，也就是说所有的泛型参数类型在编译后都会被清除掉
     */
    public void addList(List<String> stringList) {}

    //会报错
//    public void addList(List<Integer> intList) {}
}
