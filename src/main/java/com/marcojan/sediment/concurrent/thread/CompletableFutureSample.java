package com.marcojan.sediment.concurrent.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by yangyang6 on 6/27/2017.
 */
public class CompletableFutureSample {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newCachedThreadPool();

        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
            LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(2));
            System.out.println(Thread.currentThread() + " - a");
            return "a";
        },pool);

        //completableFuture.join();
        //pool.shutdown();

        completableFuture.thenApply(k -> {
            System.out.println(Thread.currentThread() + " - b");
            System.out.println("k - " + k);
            return "b";
        });
    }
}
