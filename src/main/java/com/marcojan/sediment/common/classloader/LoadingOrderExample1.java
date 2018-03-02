package com.marcojan.sediment.common.classloader;


/**
 * 准备：
 *
 * loadingOrderExample1 = null
 * counter1 = 0
 * counter2 = 0
 *
 * 初始化：（自上而下，静态属性 -> 静态代码块 -> 非静态属性 -> 非静态代码块）
 *
 * 执行：new LoadingOrderExample1(), 此时 counter1++, counter2++ 两个值都为1
 *
 * 赋值 counter1没有初始化，counter2初始化为0
 *
 * 打印：counter1=1; counter2=0
 *
 */
public class LoadingOrderExample1 {

    private static LoadingOrderExample1 loadingOrderExample1 = new LoadingOrderExample1();
    public static int counter1;
    public static int counter2 = 0;

    /**
     * 如果更换静态变量loadingOrderExample1的位置，那么按照自上而下的原则，会先赋值 counter1 和 counter2
     * 那么，就不会出现先++后赋值为0的情况
     *
     * 打印结果：counter1=1; counter2=1
     */
    //private static LoadingOrderExample1 loadingOrderExample1 = new LoadingOrderExample1();

    private LoadingOrderExample1() {
        counter1++;
        counter2++;
    }

    public static LoadingOrderExample1 getLoadingOrderExample1() {
        return loadingOrderExample1;
    }

    public static void main(String args[]){
        LoadingOrderExample1 loadingOrderExample1 = LoadingOrderExample1.getLoadingOrderExample1();
        System.out.println("counter1="+ loadingOrderExample1.counter1);
        System.out.println("counter2="+ loadingOrderExample1.counter2);
    }

}