package com.example.SpringDemo.JavaTest;

import java.util.concurrent.locks.Lock;
/*
*  死锁案例
* */
public class DeadLock implements Runnable{

    public static void main(String[] args) {
        Thread th1 = new Thread(new DeadLock(true));
        Thread th2 = new Thread(new DeadLock(false));

        //run方法只是thread的一个普通方法调用，并且是在主线程中执行的
        //start方法则是真正的开启了一个多线程，启动线程并使线程进入就绪状态
        th1.run();
        //th1.start();
        th2.start();
    }

    boolean _flag;
    static Object o1 = new Object();
    static Object o2 = new Object();
    public DeadLock(boolean _flag){
        this._flag=_flag;
    }

    @Override
    public void run() {
        if(_flag){
            synchronized (o1){
                try {
                    Thread.sleep(1000);
                    System.out.println("o1 already get");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("o1 to apply o2 success");
                }
            }
        }else{
            synchronized (o2){
                try {
                    Thread.sleep(1000);
                    System.out.println("o2 already get");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("o2 to apply o1 success");
                }
            }
        }
    }
}
