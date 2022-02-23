package com.example.SpringDemo.JavaTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
* lock和trylock的用法
* */
public class LockTest {
    public static void main(String[] args) {
        LockTest lt = new LockTest();
        //new Thread(()->{lt.lock("A");}).start();
        //new Thread(()->{lt.lock("B");}).start();

        new Thread(()->{
            try {
                lt.trylock("C");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                lt.trylock("D");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    Lock lock = new ReentrantLock();

    public void lock(String name){
        lock.lock();
        try{
            System.out.println(name+"get the lock");
        }catch (Exception e){

        }finally {
            lock.unlock();
            System.out.println(name+"release the lock");
        }
    }

    //trylock用法 在等待时间内如果获取到锁 则返回true 否则返回false
    public void trylock(String name) throws InterruptedException {
        if(lock.tryLock(1000L, TimeUnit.MILLISECONDS)){
            Thread.sleep(500);
            try {
                System.out.println(name+"get the lock");
            }catch (Exception e){

            }finally {
                lock.unlock();
                System.out.println(name+"release the lock");
            }
        }else{
            System.out.println(name+"get lock failed");
        }
    }
}
