package com.marcojan.sediment.thread.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Marco on 30/04/2017.
 */
public class Queue {

    /**
     * Queue
     *
     * 无阻塞
     *
     * 1. ConcurrentLinkedQueue:  FIFO 高性能
     * add和offer无区别，poll和peak都是从头部取出元素，poll会删除元素。
     *
     * 阻塞
     *
     * 1. ArrayBlockingQueue 有届，无读写分离
     * 2. LinkedBlockingQueue 无界，读写分离锁
     * 3. SynchronousQueue 无缓冲，生产者的数据直接被消费者消费
     */

    public static void main(String[] args) throws Exception{


        ArrayBlockingQueue<String> arrayBlockingQueue =new ArrayBlockingQueue<String>(5);

        arrayBlockingQueue.add("a");
        arrayBlockingQueue.add("b");
        arrayBlockingQueue.add("c");
        arrayBlockingQueue.add("d");
        arrayBlockingQueue.add("e");

        System.out.println(arrayBlockingQueue.offer("f",2, TimeUnit.SECONDS));

    }
}
