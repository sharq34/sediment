package com.marcojan.sediment.mq.activemq;

public class Consumer {

    MQMonitor q;

    public Consumer() {
        q = MQMonitor.getInstance();
    }

    public void consume() throws InterruptedException {
        while(true) {
            Thread.sleep(2000);
            Object obj = q.take();
            System.out.println("get the message from: "+q +" is: "+ obj);
        }
    }

    public static void main(String[] args) {
        new Runnable() {
            @Override
            public void run() {
                try {
                    new Consumer().consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.run();
    }
}
