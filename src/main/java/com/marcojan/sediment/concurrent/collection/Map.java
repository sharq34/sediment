package com.marcojan.sediment.concurrent.collection;

/**
 * @attention
 *
 * 1. ConcurrentHashMap -> hashTable
 * 2. CopyOnWriteArrayList -> Vector
 * 3. CopyOnWriteArraySet
 * 4. ConcurrentLinkedQueue
 * 5. LinkedBlockingQueue
 * 6. ArrayBlockingQueue
 * 7. PriorityBlockingQueue
 * 8. SynchronousQueue
 *
 * Created by Marco on 30/04/2017.
 */
public class Map {


    /**
     * ConcurrentMap 取代 HashTable
     *
     * 两种实现：
     *
     * 1. ConcurrentHashMap: 内部有多个segment(小的HashTable), 最多支持16个segment，减小了锁的粒度，解决了多线程锁竞争的问题。
     *
     * 2. ConcurrentSkipListMap: 支持排序（TreeMap）
     *
     */
    public static void main(String[] args) {

    }

}
