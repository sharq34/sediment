package com.marcojan.sediment.designmodel.singleton;

/**
 * Created by Marco on 30/04/2017.
 */
public class SingletonInnerClass {

    private static class Singleton {
        private static Singleton singleton =new Singleton();
    }

    public static Singleton getInstance(){
        return Singleton.singleton;
    }

}
