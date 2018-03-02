package com.marcojan.sediment.common.classloader;

public class LoadingOrderExample3 {

    public static int x =6/3;
    static {
        System.out.println("FinalTest static block");

        /**
         * 先加载静态属性，后加载静态代码块
         * 这里，x值先在属性 6/3 赋值为2，后在静态代码块里赋值为1
         */
        //x = 1;
    }

    public static void main(String args[]){
        System.out.println(x);
        //System.out.println(TLoadingOrderEample3InnerClass.x);
    }
}

/**
 * final变量在加载的时候就已经赋值为2, 如果去掉final关键字, 那么会先执行 static 代码块
 *
class TLoadingOrderEample3InnerClass{
    public final static int x =6/3;
    static {
        System.out.println("FinalTest static block");
    }
}
*/