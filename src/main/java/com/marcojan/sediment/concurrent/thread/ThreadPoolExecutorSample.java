package com.marcojan.sediment.concurrent.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 *
 * Created by Marco on 30/04/2017.
 */
public class ThreadPoolExecutorSample extends Thread {

    static class MyRejectStratgy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            executor.shutdown();
            System.out.println("enter RejectedHandler..");
        }
    }


    public ThreadPoolExecutorSample(String name) {
        super(name);
    }

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                1,
                2,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                new MyRejectStratgy());

        ThreadPoolExecutorSample t1 = new ThreadPoolExecutorSample("t1");
        ThreadPoolExecutorSample t2 = new ThreadPoolExecutorSample("t2");
        ThreadPoolExecutorSample t3 = new ThreadPoolExecutorSample("t3");
        ThreadPoolExecutorSample t4 = new ThreadPoolExecutorSample("t4");
        ThreadPoolExecutorSample t5 = new ThreadPoolExecutorSample("t5");
        ThreadPoolExecutorSample t6 = new ThreadPoolExecutorSample("t6");

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);

        //因为 corePoolSize =1 maxmumPoolSize=2 queueCapacity=3 2+3=5
        pool.execute(t6);

        pool.shutdown();

        /**
         * LinkedBlockingQueue
         */
    }

    @Override
    public void run() {
        System.out.println("run: " + super.getName());
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
