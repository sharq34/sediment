package com.marcojan.sediment.concurrent.collection;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Marco on 30/04/2017.
 */
public class CopyOnWrite {

    /**
     * COW: CopyOnWrite 实现了读写分离。
     *
     * a. 先复制一个原容器的副本
     * b. 然后做添加删除操作
     * c. 再将原容器指向这个副本
     * d. 同时回收原地址引用（垃圾处理）
     *
     * pros: 适合读多写少的场景。
     * cons: 如果写太多的话，那非常浪费内存，因为创建了很多的元素。
     *
     * 1. CopyOnWriteArrayList
     * 2. CopyOnWriteArraySet
     *
     * TODO:
     *
     * 1. 多个写操作，CopyOnWriteArrayList怎么实现的？
     * 2. 读写锁？
     */
    public static void main(String[] args) {

        CopyOnWriteArrayList<String> copyOnWriteArrayList= new CopyOnWriteArrayList<String>();

        //copyOnWriteArrayList.stream().
    }

}
