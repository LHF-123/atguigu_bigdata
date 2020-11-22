package com.atguigu.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket{//资源类 = 实例变量 + 实例方法

    private int number = 80;
    Lock lock = new ReentrantLock();//可重入锁  多态引用

    public void sale(){
        lock.lock();
        try { 
          if (number > 0){
              System.out.println(Thread.currentThread().getName()+"\t卖出第："+(number--)+"\t还剩下："+number);
          }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          lock.unlock();
        }
    }

}

/**
 * @author LHF
 * @create 2020-11-22-14:36
 *
 * 题目：三个售票员         卖出      30张票
 * 笔记：如何编写企业级的多线程代码
 *  固定的编程套路+模板是什么？
 *
 *  1 在高内聚低耦合的前提下  线程   操作  资源类
 *      1.1一言不合，先创建一个资源类
 */
public class SaleTicketDemo01 {

    public static void main(String[] args) {//主线程，一切程序的入口
        Ticket ticket = new Ticket();

        //Thread(Runnable target, String name) Allocates a new Thread object.

        //用lambda表达式简化代码
        new Thread(() -> {for (int i = 0; i < 100; i++) ticket.sale();},"A").start();
        new Thread(() -> {for (int i = 0; i < 100; i++) ticket.sale();},"B").start();
        new Thread(() -> {for (int i = 0; i < 100; i++) ticket.sale();},"C").start();

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    ticket.sale();
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    ticket.sale();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    ticket.sale();
                }
            }
        },"C").start();*/
    }

}
