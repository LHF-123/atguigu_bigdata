package com.atguigu.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author lhf
 * @create 2020-11-24 10:31
 *
 * 8 lock
 *
 * 1 标准访问，请问先打印邮件还是短信
 *      线程没睡眠的话看CPU调度，睡眠100毫秒，先打印邮件，后打印短信
 * 2 暂停3秒在邮件方法，请问时先打印邮件还是短信
 *      先打印邮件，后打印短信
 *      锁的时当前对象this，被锁定后，其他线程都不能进入当前对象的其他synchronized方法
 * 3 新增sayHello方法，请问是先打印sayHello还是邮件
 *      先打印sayHello，然后打印邮件
 *      加的普通方法与同步锁无关
 * 4 两部手机，请问是先打印邮件还是短信
 *      先打印短信，后打印邮件
 *      换成两个对象后就不是同一把锁了
 * 5 两个静态同步方法，同一部手机，请问是先打印邮件还是短信
 *      先打印邮件，后打印信息
 *      对于静态同步方法锁的是当前类的Class对象
 * 6 两个静态同步方法，两部手机，请问是先打印邮件还是短信
 *      先打印邮件，后打印信息
 *      对于静态同步方法锁的是当前类的Class对象
 * 7 一个静态同步方法，一个普通同步方法，同一部手机，请问是先打印邮件还是短信
 *      先发送短信，后发送邮件
 *      静态同步方法和普通的同步方法，这两把锁，锁的是不同的对象，所以静态同步方法和其他非静态同步
 * 8 一个静态同步方法，一个普通同步方法，两部手机，请问是先打印邮件还是短信
 *      先发送短信，后发送邮件
 *      静态同步方法和普通的同步方法，这两把锁，锁的是不同的对象，所以静态同步方法和其他非静态同步
 *
 *  synchronized实现同步的基础：Java中每一个对象都可以作为锁。
 *  具体表现为一下三种形式：
 *  对于普通同步方法，锁的是当前实例对象，锁的是当前对象this
 *  对于同步方法块，锁的是synchronized括号里配置的对象
 *  对于静态同步方法，锁的是当前类的Class对象
 */

/**
 * @author lhf
 * @create 2020-11-24 11:19
 * 笔记
 *  一个对象里如果有多个synchronized方法，某一时刻，只要一个线程去调用其中一个synchronized方法了，
 *  其他的线程只能等待，话句话说，某一时刻，只能由唯一一个线程去访问这些synchronized方法
 *
 *  锁的是当前对象this，被锁定后，其他的线程都不能进入到当前对象的其他方法
 *
 *  加个普通方法后发现和同步锁无关了
 *  换成两个对象后，不是同一把锁了
 *
 *  都换成静态同步方法后
 *  所有的非静态同步方法用的都是同一把锁--实例对象本身
 *
 *  synchronized实现同步的基础：Java中每一个对象都可以作为锁。
 *  具体表现为一下三种形式：
 *  对于普通同步方法，锁的是当前实例对象，锁的是当前对象this
 *  对于同步方法块，锁的是synchronized括号里配置的对象
 *  对于静态同步方法，锁的是当前类的Class对象
 *
 *  当一个线程试图访问同步代码块时，他首先必须得到锁，退出或抛出异常时必须释放锁。
 *  也就是说如果一个实例对象的非静态同步方法获取锁后，该实例对象的其他非静态同步方法必须等待获取锁的方法释放锁后才能获取锁，
 *  可是别的实例对象的非静态同步方法因为跟该实例对象的非静态同步方法用的是不同的锁，
 *  所以无需等待该实例对象以获取锁的非静态同步方法释放锁就可以获取他们自己的锁
 *
 *  所有的静态同步方法用的是同一把锁--类对象Class本身，
 *  静态同步方法和普通的同步方法，这两把锁，锁的是不同的对象，所以静态同步方法和其他非静态同步
 *      之间不会有竞态条件的
 *  但是一旦一个静态同步方法获取锁后，其他的静态同步方法都必须等待该方法释放锁后才能获取锁。
 *  而不管是同一个实例对象的静态同步方法之间，
 *  还是不同实例对象的静态同步方法之间，只要他们是同一个类的实例对象
 *
 */

//资源类
class Phone{

    public static synchronized void sendEmail() throws Exception{
        TimeUnit.SECONDS.sleep(3);
        System.out.println("****sendEmail");
    }

    public synchronized void sendSMS() throws Exception{
        System.out.println("****sendSMS");
    }

    public void sayHello(){
        System.out.println("****sayHello");
    }

}

public class Lock8Demo05 {

    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            try{
                phone.sendEmail();
            } catch (Exception e){
                e.printStackTrace();
            }
        },"A").start();

        Thread.sleep(100);

        new Thread(() -> {
            try{
                phone.sendSMS();
//                phone.sayHello();
//                phone2.sendSMS();
            } catch (Exception e){
                e.printStackTrace();
            }
        },"B").start();

    }

}