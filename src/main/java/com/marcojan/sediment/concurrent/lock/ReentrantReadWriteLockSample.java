package com.marcojan.sediment.concurrent.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读多写少的情况下使用
 *
 * 读读共享，写写互斥，读写互斥
 *
 * Created by Marco on 01/05/2017.
 */
public class ReentrantReadWriteLockSample {

    ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

}
