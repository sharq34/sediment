package com.marcojan.sediment.concurrent.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

/**
 * Java限流
 * <p>
 * Redis限流，存URL和用户的IP，加黑名单。
 * <p>
 * Created by Marco on 01/05/2017.
 */
public class SemaphoreSample {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(5);

        ExecutorService executorService = Executors.newCachedThreadPool();

        int i = 0;
        for (; i < 20; i++) {
            final int INDEX = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("线程 - " + INDEX);
                    sleep((long) (10000* Math.random()));
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
