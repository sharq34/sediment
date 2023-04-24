package com.marcojan.sediment.mq.activemq;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Producer implements Runnable{

    MQMonitor q;

    public Producer() {
        q = MQMonitor.getInstance();
    }

    public void work() throws InterruptedException {
        while (true) {
            Thread.sleep(2000);
            Object obj = new Object();
            Boolean putFlag = q.put(obj);
            System.out.println("Producer put obj: " + obj + " and the result is " + putFlag);
        }
    }

    @Override
    public void run() {
        try {
            work();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();

        service.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new Producer().work();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });

        service.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    new Consumer().consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
