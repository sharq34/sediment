package com.marcojan.sediment.concurrent.lock;

/**
 * 类锁和对象锁 static关键字
 * <p>
 * synchronized关键字加在 static 方法前面，持有的是类锁。
 * 反之，如果没有 static 关键字，持有的是实例锁。
 * <p>
 * 结论：
 * <p>
 * 1. 持有类锁，那么即使是不同实例对象，也无法访问共享资源：例如s1.t3()和s2.t4() 【等待】
 * 2. 持有实例对象锁，那么 synchronized 持有该实例对象的锁：例如 s1.t1()和s1.t2() 【等待】
 * 3. 类锁和实例对象锁互不干涉：例如 StaticSynchronizedSample.t3()和 s1.t1() 【不等待】
 *
 * Created by Marco on 11/03/2018.
 */
public class StaticSynchronizeSample {

    // static 对象也是全局唯一的，锁定资源的时候和 static 的效果一致
    static Object lock1 = new Object();
    Object lock2 = new Object();

    synchronized static void t3() {
        System.out.println("t3 method..");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized static void t4() {
        System.out.println("t4 method..");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StaticSynchronizeSample s1 = new StaticSynchronizeSample();
        StaticSynchronizeSample s2 = new StaticSynchronizeSample();

        new Thread() {
            @Override
            public void run() {
                System.out.println("enter thread1");
                s1.t5();
                System.out.println("thread1 done.");
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println("enter thread2");
                s2.t6();
                System.out.println("thread2 done.");
            }
        }.start();

    }

    synchronized void t1() {
        System.out.println("t1 method..");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void t2() {
        System.out.println("t2 method..");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void t5() {
        synchronized (lock1) {
            System.out.println("t1 method..");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void t6() {
        synchronized (lock1) {
            System.out.println("t2 method..");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
