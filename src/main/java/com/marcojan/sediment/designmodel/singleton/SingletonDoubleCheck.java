package com.marcojan.sediment.designmodel.singleton;

/**
 * Created by Marco on 30/04/2017.
 */
public class SingletonDoubleCheck {

    private static volatile SingletonDoubleCheck inst;

    private SingletonDoubleCheck() {
    }

    public static SingletonDoubleCheck getInstance() {

        if (inst == null) {
            synchronized (inst) {
                if (inst == null)
                    inst = new SingletonDoubleCheck();
            }
        }

        return inst;
    }

}
