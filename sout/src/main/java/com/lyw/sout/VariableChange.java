package com.lyw.sout;

import com.lyw.sout.modle.Student;

public class VariableChange {
    public static void main(String[] args) {
        Student a = new Student(1);
        Student b = a;

        b.setAge(3);
        System.out.println(b);
        System.out.println(a);

        int c = 1;
        int d = c;
        d++;
        System.out.println(c);
        System.out.println(d);
    }
}
