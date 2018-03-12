package com.marcojan.sediment.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多Conditions的应用
 * Created by Marco on 01/05/2017.
 */
public class ManyConditionSample {

    ReentrantLock lock =new ReentrantLock();
    Condition cond1 =lock.newCondition();
    Condition cond2 =lock.newCondition();


}
