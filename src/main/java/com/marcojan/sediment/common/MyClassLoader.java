package com.marcojan.sediment.common;

/**
 * Created by Marco on 07/05/2017.
 */
public class MyClassLoader {

    public static int counter1;
    public static int counter2 = 0;
    private static MyClassLoader myClassLoader = new MyClassLoader();

    private MyClassLoader() {
        counter1++;
        counter2++;
    }

    public static MyClassLoader getSingleton() {
        return myClassLoader;
    }

}
