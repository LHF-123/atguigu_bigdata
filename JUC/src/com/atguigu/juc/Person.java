package com.atguigu.juc;

/**
 * @author LHF
 * @date 2020/12/2 13:55
 */
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
