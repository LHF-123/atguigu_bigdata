package com.atguigu.jvm;

/**
 * @author LHF
 * @date 2020/11/28 23:05
 *
 * 主题：JVM
 *
 * 1 JVM系统架构图
 *
 * 2 类加载器
 *System.out.println(myObject.getClass().getClassLoader().getParent().getParent());
 *System.out.println(myObject.getClass().getClassLoader().getParent());
 *System.out.println(myObject.getClass().getClassLoader());
 *
 *  2.1 有哪几种类加载器
 *  2.2 双亲委派机制
 *  2.3 沙箱安全机制
 *
 * 3 Native
 *  3.1 native是一个关键字
 *  3.2 有声明，无实现，why?
 *
 * 4 PC寄存器
 *  4.1记录了方法之间的调用和执行情况，类似排版的值日表
 *     用来存储指向下一条指令的地址，也即将要执行的指令代码
 *     它是当前线程执行的字节码文件的行号指示器
 *
 * 5 方法区
 *  5.1 它存储了每一个类的结构信息
 *  5.2 方法区是规范，在不同虚拟机里的实现是不一样的，最典型的就是永久代(PermGen space)和元空间(Metaspace)
 *
 *      空调 k1 = new 格力();
 *      List list = new ArrayList();
 *
 *      方法区 f = new 永久代();
 *      方法区 f = new 元空间();
 *
 * 6 stack
 *  6.1 栈管运行，堆管存储
 *  6.2 栈保存哪些东西？
 *      8中基本数据类型 + 对象的引用变量 + 实例方法 都是在函数的栈内存中分配的。
 *
 *  6.3 Exception in thread "main" java.lang.StackOverflowError
 *
 * 7 heap堆
 *
 * 8 heap --> 对象的生命周期 --> OOM
 */
public class JVMNote {

    public static void main(String[] args){

    }



}
