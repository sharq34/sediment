package com.marcojan.sediment.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 *
 * JDK1.8之前，synchronized的效率略低
 *
 * JDK1.8之后：
 *
 * 1. 效率上，synchronized和ReentrantLock没有区别
 * 2. 使用上，ReentrantLock的使用更加灵活
 *
 * DIFF:
 *
 * 1. ReentrantLock 可以为公平锁和非公平锁，synchronized 只能费公平锁
 * 2. ReentrantLock 可以使用lockInterruptibly 打断锁，而 synchronized 只能一直等待
 * 3. 可以有多个 Condition 条件
 *
 * Created by Marco on 01/05/2017.
 */
public class ReentrantLockSample {

    //公平锁和非公平锁
    //new ReentrantLock() 默认非公平锁
    //公平锁效率低，因为要维护一个队列表示线程的顺序
    Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ReentrantLockSample sample = new ReentrantLockSample();
        executorService.execute(() -> {
            try {
                sample.method1();
                sample.method2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void method1() throws InterruptedException {

        try {
            lock.lock();
            System.out.println("进入method1");
            sleep(2000);
            System.out.println("结束method1");
        } finally {
            lock.unlock();
        }
    }

    public void method2() throws InterruptedException {

        try {
            lock.lock();
            System.out.println("进入method2");
            sleep(3000);
            System.out.println("结束method2");
        } finally {
            lock.unlock();
        }
    }
}
