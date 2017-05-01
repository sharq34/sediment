package com.marcojan.sediment.concurrent;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Marco on 30/04/2017.
 */
public class MyBlockingQueue<T> {

    private final static int INIT_SIZE = 5;

    /**
     * Difference of ArrayDeque & PriorityQueue
     */
    private volatile Queue<T> myBlockingQueue = new PriorityQueue<T>(INIT_SIZE);

    public static void main(String[] args) {

        final MyBlockingQueue<Integer> sample = new MyBlockingQueue<Integer>();

        Thread producer = new Thread(new Runnable() {
            public void run() {

                int i = 10, n = 1;
                synchronized (sample) {

                    while (true) {

                        if (sample.size() == 5) {
                            try {
                                System.out.println("full of queue, waiting...");
                                sample.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        int val;
                        sample.push(val = i * n++);
                        System.out.println("[producer] put element into myBlockingQueue: " + String.valueOf(val));
                        sample.notify();
                    }
                }

            }
        }, "producer");

        Thread consumer = new Thread(new Runnable() {

            public void run() {

                synchronized (sample) {

                    while (true) {

                        if (sample.size() == 0) {

                            System.out.println("no data and notify producing Thread...");
                            try {
                                sample.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Integer val = sample.take();
                        System.out.println("{consumer} take the val: " + val + ", and the size of such queue = " + sample.size() + ". ");

                        sample.notify();
                    }
                }
            }
        }, "consumer");


        producer.start();
        consumer.start();
    }

    public T take() {

        T element = myBlockingQueue.poll();

        return element;
    }

    public int push(T element) {

        myBlockingQueue.add(element);

        return myBlockingQueue.size();
    }

    public int size() {
        return myBlockingQueue.size();
    }

    @Override
    public String toString() {

        return myBlockingQueue.toString();
    }

}
