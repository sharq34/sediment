package com.marcojan.sediment.concurrent;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

/**
 * Future其实是线程的异步 AJAX
 * <p>
 * Created by Marco on 30/04/2017.
 */
public class FutureSample implements Callable<String> {


    String queryString;

    public FutureSample(String queryString) {
        this.queryString = queryString;
    }

    @Override
    public String call() throws Exception {

        sleep(5000);
        System.out.println("执行一些操作...");

        return queryString+" 分支任务完成..";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * submit 和 execute 的区别
         *
         * submit 有返回值，可以传入callable接口
         */
        FutureTask<String> futureTask = new FutureTask<String>(new FutureSample("执行查询"));

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future future = executorService.submit(futureTask);

        //处理实际的业务
        sleep(2000);
        System.out.println("处理实际的业务");

        //get方法会阻塞
        //futureTask.get方法阻塞，获取返回值
        System.out.println(futureTask.get());

        System.out.println("主线程结束");

        executorService.shutdown();
    }

}
