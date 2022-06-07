package com.lyw.sout;

import java.util.HashSet;

/**
 * @author liuyaowei488
 * @date created in 2019-8-20 15:21
 */
public class ClassNameSout {
    /**
     * 测试输出类名
     * @param args
     * @return name is : com.lyw.sout.ClassNameSout
     * <br/> simpleName is : ClassNameSout
     */
    public static void main(String[] args) {
        System.out.println("class name is: " + ClassNameSout.class.getName());
        System.out.println("class simpleName is: " + ClassNameSout.class.getSimpleName());
    }
}
