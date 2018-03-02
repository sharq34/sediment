package com.marcojan.sediment.designmodel.singleton;

/**
 * Created by Marco on 30/04/2017.
 */
public class SingletonDoubleCheck {

    private static SingletonDoubleCheck sdc;

    private SingletonDoubleCheck() {
    }

    public static SingletonDoubleCheck getInstance() {
        if (sdc == null) {

            //耗时的业务操作
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (SingletonDoubleCheck.class) {
                //if (sdc == null)
                sdc = new SingletonDoubleCheck();
            }
        }
        return sdc;
    }

    public static void main(String[] args) {


        Runnable r1 = () -> {
            SingletonDoubleCheck sdc = SingletonDoubleCheck.getInstance();
            System.out.println(sdc.hashCode());
        };
        r1.run();

        Runnable r2 = () -> {
            SingletonDoubleCheck sdc = SingletonDoubleCheck.getInstance();
            System.out.println(sdc.hashCode());
        };

        r2.run();
        Runnable r3 = () -> {
            SingletonDoubleCheck sdc = SingletonDoubleCheck.getInstance();
            System.out.println(sdc.hashCode());
        };
        r3.run();

        Runnable r4 = () -> {
            SingletonDoubleCheck sdc = SingletonDoubleCheck.getInstance();
            System.out.println(sdc.hashCode());
        };
        r4.run();

        Runnable r5 = () -> {
            SingletonDoubleCheck sdc = SingletonDoubleCheck.getInstance();
            System.out.println(sdc.hashCode());
        };
        r5.run();

    }
}
