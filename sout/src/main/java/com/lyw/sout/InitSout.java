package com.lyw.sout;

import lombok.Data;

/**
 * 对象初始化测试方法
 */
public class InitSout {
    @Data
    static class Student {
        String name;
        Student(){}
        public Student(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        //直接使用new关键字初始化String，s为空字符串，""
        String s = new String();
        System.out.println(s);
        //对象中的字符串初始化，没当作构造参数时，为null对象
        Student student = new Student();
        System.out.println(student);
    }
}
