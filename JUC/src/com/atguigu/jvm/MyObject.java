package com.atguigu.jvm;

/**
 * @author LHF
 * @date 2020/11/28 22:36
 */
public class MyObject {
    
    public static void main(String[] args){
        Object object = new Object();
        System.out.println(object.getClass().getClassLoader());

        System.out.println("*************************");

        MyObject myObject = new MyObject();
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());
        System.out.println(myObject.getClass().getClassLoader().getParent());
        System.out.println(myObject.getClass().getClassLoader());
    }
    
}
