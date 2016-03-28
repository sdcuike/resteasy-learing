package com.doctor.resteasy.demo01;

import java.io.Serializable;

/**
 * @author sdcuike
 *
 *         Create At 2016年3月28日
 */
public class Demo01Request implements Serializable {

    private static final long serialVersionUID = 8592009151008599867L;

    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
