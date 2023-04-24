package com.marcojan.sediment.mq.activemq;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 1 q java 类来模拟
 * 2 生产者 & 消费者
 */
public class MQMonitor {

    public static BlockingDeque q = new LinkedBlockingDeque();
    public static MQMonitor MONITOR = new MQMonitor();

    private MQMonitor() {
    }

    public static MQMonitor getInstance() {
        return MONITOR;
    }

    public boolean put(Object obj) {

        Boolean flag = q.add(obj);
        System.out.println("insert into: " + MONITOR + " with element: " + obj + " and the size of the q is: " + q.size());
        return flag;
    }

    public Object take() {
        Object obj = q.poll();
        System.out.println("get element from "+ MONITOR+" : "+obj);
        return obj;
    }
}

