package com.lyw.annotationInterface;

/**
 * @author liuyaowei488
 * @date created in 2019-12-13 15:54
 */
public class Statudent {
    @StringNotEmpty(msg = "name not allowed null")
    private String name;
    private String sex;

    public Statudent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
