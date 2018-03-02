package com.marcojan.sediment.designmodel.singleton;

/**
 * Created by Marco on 30/04/2017.
 */
public class SingletonInnerClass {

    /**
     * 类加载时机就5个:
     * 1、使用new,invokestatic,putstatic,getstatic指令时若该类未加载则触发
     * 2、反射使用某个类时若该类未加载则触发
     * 3、子类加载时若父类未加载则触发
     * 4、程序开始时主方法所在的类会被加载
     *
     * 懒加载是第一种情况。
     *
     * 为什么外部类加载时静态内部类未加载
     * 《effective java》里面说静态内部类只是刚好写在了另一个类里面，实际上和外部类没什么附属关系。
     *
     * 线程安全是因为，类加载的初始化阶段是单线程的
     * 类变量的赋值语句在编译生成字节码的时候写在函数中，初始化时单线程调用这个完成类变量的赋值。
     */
    private static class Singleton {
        private static Singleton singleton =new Singleton();
    }

    public static Singleton getInstance(){
        return Singleton.singleton;
    }

}
