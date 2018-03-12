package com.marcojan.sediment.concurrent.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @attention
 *
 * 1. wait 释放锁 & notify 不释放锁
 *
 * Created by Marco on 30/04/2017.
 */
public class WaitNotifySample {

    public static void main(String[] args) {

        final Object lock = new Object();
        final List list = new ArrayList();

        CountDownLatch countDownLatch =new CountDownLatch(1);

        Thread t1 = new Thread(new Runnable() {
            public void run() {

                synchronized (lock) {
                    System.out.println("进入t1...");
                    int i = 0;
                    while (i++ < 10) {

                        System.out.println(Thread.currentThread().getName() + " 添加元素，当前大小为：" + list.size());
                        list.add("test");

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (i == 5) {
                            System.out.println("发出通知");
                            try {
                                lock.notify();
                                //lock.wait();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }

            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            public void run() {

                synchronized (lock) {
                    System.out.println("进入t2...");
                    if (list.size() != 5) {
                        try {
                            lock.wait();
                            throw new RuntimeException();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            //lock.notify();
                        }
                    }
                }
            }
        }, "t2");

        t2.start();
        t1.start();
    }
}
