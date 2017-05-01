package com.marcojan.sediment.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * 一个Lock对象可以创建多个Conditions，使锁的交互特别灵活
 * Created by Marco on 01/05/2017.
 */
public class ConditionSample {

    ReentrantLock lock =new ReentrantLock();
    Condition condition = lock.newCondition();

    private void method1 (){

        try{
            lock.lock();
            System.out.println("进入method1");
            sleep(1500);
            System.out.println("await释放锁");
            sleep(1500);
            condition.await();
            sleep(1500);
            System.out.println("重新进入method1，继续执行。" );
            condition.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    private void method2 (){

        try{
            lock.lock();
            System.out.println("进入method2");
            sleep(1500);
            System.out.println("signal通知别的线程");
            condition.signal();
            condition.await();

            for(int i =0 ; i<10;i++) {
                sleep(1000);
                System.out.println("method2继续执行业务："+i);
            }
            //System.out.println("因为signal没有释放锁，重新进入method2，继续执行。" );

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        final ConditionSample cs =new ConditionSample();

        executorService.execute(()->{
            cs.method1();
        });
        executorService.execute(()->{
            cs.method2();
        });

        executorService.shutdown();
    }
}
