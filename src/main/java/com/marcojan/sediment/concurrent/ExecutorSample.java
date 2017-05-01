package com.marcojan.sediment.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Marco on 30/04/2017.
 */
public class ExecutorSample {

    /**
     * 1. newFixedThreadPool
     * 2. newSingleThreadExecutor
     * 3. newCachedThreadPool
     * 4. newScheduledThreadPool
     *
     */
    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        scheduledExecutorService.schedule(new Runnable() {

            @Override
            public void run() {
                System.out.println("run");
            }
        },1, TimeUnit.SECONDS);

    }
}
