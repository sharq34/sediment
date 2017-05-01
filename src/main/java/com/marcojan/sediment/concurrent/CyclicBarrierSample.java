package com.marcojan.sediment.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

/**
 * CyclicBarrier和CountDownLatch的区别
 *
 * 1. CyclicBarrier是每个线程阻塞，达到new CyclicBarrier(n)的n之后，会恢复主线程。
 * 2. CountDownLatch是一个线程阻塞，收到多个countDown之后恢复，
 * Created by Marco on 01/05/2017.
 */
public class CyclicBarrierSample {

    static class Runner implements Runnable{

        CyclicBarrier barrier;
        String name;

        public Runner(String name, CyclicBarrier cyclicBarrier) {
            this.barrier = cyclicBarrier;
            this.name=name;
        }

        @Override
        public void run() {
            try {
                sleep(3000);
                System.out.println(name +" 准备ok! ");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println(name+" GO!!! ");
        }
    }

    public static void main(String[] args) throws Exception{

        // 当这个值为4的时候就阻塞了，因为下面值启动了t1,t2,t3三个线程
        CyclicBarrier cyclicBarrier =new CyclicBarrier(3);

        ExecutorService pool = Executors.newFixedThreadPool(3);

        pool.submit(new Thread(new Runner("t1",cyclicBarrier)));
        sleep(1000);
        pool.submit(new Thread(new Runner("t2",cyclicBarrier)));
        sleep(1000);
        pool.submit(new Thread(new Runner("t3",cyclicBarrier)));

        pool.shutdown();
    }
}
