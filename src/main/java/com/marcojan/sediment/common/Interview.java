package com.marcojan.sediment.common;

/**
 * Created by Marco on 02/05/2017.
 */
public class Interview {

    static void tx_switch(int type){
        switch (type) {
            default:
                System.out.println(4);
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
            case 3:
                System.out.println(3);
        }

    }

    /**
     * new String(value, beginIndex, subLen)
     *
     * 所以需要将 ss 指向新的地址
     * @param ss
     */
    static void tx_substring(String ss){

        ss.substring(2);
        // ss = ss.substring(2);
        System.out.println(ss);
    }

    public static void main(String[] args) {
        tx_switch(4);
    }
}
