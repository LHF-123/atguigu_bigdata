package com.atguigu.jvm;

/**
 * @author LHF
 * @date 2020/12/4 16:10
 *
 * 引用计数法
 *
 *  缺点：
 *   1 每次对对象赋值均要维护引用计数器，且计数器本身也有一定的消耗
 *   2 较难处理循环引用
 *
 * JVM一般不采用这种方式
 */
public class ReferenceCount {

    private byte[] bigSize = new byte[2 * 1024 * 1024];//这个成员属性唯一的作用就是占用一点内存
    Object instance = null;

    public static void main(String[] args){
        ReferenceCount objectA = new ReferenceCount();
        ReferenceCount objectB = new ReferenceCount();

        //循环引用
        objectA.instance = objectB;
        objectB.instance = objectA;
        objectA = null;
        objectB = null;

        System.gc();
    }

}
