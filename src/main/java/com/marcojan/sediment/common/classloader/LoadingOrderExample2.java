package com.marcojan.sediment.common.classloader;

/**
 *  准备阶段: 为类变量分配内存并设置默认值, 因此类变量st为null、b为0;
 *
 *  需要注意的是如果类变量是 final, 编译时 javac 将会为 value 生成 ConstantValue 属性, 在准备阶段虚拟机就会根据 ConstantValue 的设置将变量设置为指定的值, 如果这里这么定义：static final int b = 112, 那么在准备阶段 b 的值就是112, 而不再是0了
 *
 *  初始化阶段: 需要做是执行类构造器, 因此先执行第一条静态变量的赋值语句即st = new StaticTest (), 此时会进行对象的初始化，对象的初始化是先初始化成员变量再执行构造方法, 因此设置a为110 -> 打印2 -> 执行构造方法 (打印3,此时a已经赋值为110，但是b只是设置了默认值0，并未完成赋值动作), 等对象的初始化完成后继续执行之前的类构造器的语句.
 *
 *  后面按照语句在源码中的顺序执行即可.
 *
 *  http://blog.csdn.net/u013256816/article/details/50837863
 *
 *
 *  打印结果:
 *
 *  2
 *  3
 *  a = 110, b = 0
 *  1
 *  4
 */
public class LoadingOrderExample2
{
    public static void main(String[] args)
    {
        staticFunction();
    }

    static LoadingOrderExample2 st = new LoadingOrderExample2();

    static
    {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    LoadingOrderExample2()
    {
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }

    public static void staticFunction(){
        System.out.println("4");
    }

    int a=110;
    static int b =112;
}