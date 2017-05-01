package com.marcojan.sediment.concurrent.collection;

import java.util.concurrent.PriorityBlockingQueue;

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

    public static void main(String[] args) throws Exception {


        /**
         * ArrayBlockingQueue
         */
//        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(5);
//
//        arrayBlockingQueue.add("a");
//        arrayBlockingQueue.add("b");
//        arrayBlockingQueue.add("c");
//        arrayBlockingQueue.add("d");
//        arrayBlockingQueue.add("e");
//
//        //因为初始化new的时候指定了默认capacity为5，所以offer这个值没有被添加进去。
//        arrayBlockingQueue.offer("f");
//
//        //延迟两秒，返回值为boolean
//        boolean flag = arrayBlockingQueue.offer("f", 2, TimeUnit.SECONDS);
//        System.out.println("offer method with 3 parameters did not work.");
//
//        System.out.println(arrayBlockingQueue.size());
//
//        arrayBlockingQueue.forEach(e -> System.out.println(e));


        /**
         * TODO: LinkedBlockingQueue
         */

        /**
         * SynchronousQueue
         */
//        final SynchronousQueue<String> synchronousQueue =new SynchronousQueue<>();
//
//        new Thread(()  -> {
//            try {
//                while(true)
//                System.out.println(synchronousQueue.take());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        },"consumer").start();
//
//        new Thread(()->{
//            int i =1;
//            while(true){
//            synchronousQueue.offer(String.valueOf(i++));
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }}).start();


        /**
         * PriorityBlockingQueue: 基于比较 必须实现Comparator接口
         *
         * 队列实现了排序
         */
        class Task implements Comparable<Task> {
            int id;
            String name;

            public Task(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public int compareTo(Task task) {
                return this.id > task.id ? 1 : -1;
            }
        }

        PriorityBlockingQueue<Task> priorityBlockingQueue = new PriorityBlockingQueue<Task>();

        Task t1 = new Task(2, "2");
        Task t2 = new Task(1, "1");
        Task t3 = new Task(3, "3");

        priorityBlockingQueue.add(t1);
        priorityBlockingQueue.add(t2);
        priorityBlockingQueue.add(t3);

        priorityBlockingQueue.forEach(e -> System.out.println(e.getName()));

    }
}
