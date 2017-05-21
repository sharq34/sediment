package com.marcojan.sediment.common;

/**
 * Created by Marco on 07/05/2017.
 */
public class TestMyClassLoader {

    public static void main(String args[]){
        MyClassLoader myClassLoader = MyClassLoader.getSingleton();
        System.out.println("counter1="+myClassLoader.counter1);
        System.out.println("counter2="+myClassLoader.counter2);
    }
}
