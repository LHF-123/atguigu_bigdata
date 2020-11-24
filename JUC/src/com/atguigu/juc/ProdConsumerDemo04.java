package com.atguigu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Aircondition{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception{
        lock.lock();
        try {
            while (number != 0){
                condition.await();//this.wait();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();//this.notifyAll();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception{
        lock.lock();
        try {
            while (number == 0){
                condition.await();//this.wait();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t\t"+number);
            condition.signalAll();//this.notifyAll();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //旧版写法
    /*public synchronized void increment() throws Exception{
        //判断
        while (number != 0){
            this.wait();
        }
        //干活
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //通知
        this.notifyAll();
    }

    public synchronized void decrement() throws Exception{
        //判断
        while (number == 0){
            this.wait();
        }
        //干活
        number--;
        System.out.println(Thread.currentThread().getName()+"\t\t"+number);
        //通知
        this.notifyAll();
    }*/
}
/**
 * @author lhf
 * @create 2020-11-24 17:35
 *
 * 题目：现在两个线程，可以操作初始值为0的一个变量，
 *      实现一个线程对该变量加1，一个线程对该变量减1，
 *      实现交替，来10轮，变量初始值为0
 *
 * 1    高聚低合前提下，线程操作资源类
 * 2    判断/干活/通知
 * 3    防止虚假唤醒      资源类的判断if改为while
 *
 * 知识小总结 = 多线程编程套路 + while判断 + 新版写法
 */
public class ProdConsumerDemo04 {

    public static void main(String[] args) {
        Aircondition aircondition = new Aircondition();

        threadTestIn(aircondition,"A");
        threadTestDe(aircondition,"B");
        threadTestIn(aircondition,"C");
        threadTestDe(aircondition,"D");

    }

    public static void threadTestDe(Aircondition aircondition, String name){
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try{
                    aircondition.decrement();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },name).start();
    }

    public static void threadTestIn(Aircondition aircondition, String name){
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try{
                    aircondition.increment();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },name).start();
    }

}
