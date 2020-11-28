package com.atguigu.jvm;

/**
 * @author LHF
 * @date 2020/11/28 23:00
 */
public class T {

    public static void main(String[] args){
        Thread t1 = new Thread();
        t1.start();
        t1.start();
        //Exception in thread "main" java.lang.IllegalThreadStateException
    }

}
