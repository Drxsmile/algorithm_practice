package com.snx;

// lazy
public class Singleton2 {
    private volatile static Singleton2 s2 = null;
    private Singleton2(){

    }

    public static Singleton2 getInstance() {
        if(s2 == null){ // 如去掉，每次都需要拿锁，性能开销大
            synchronized (Singleton2.class) {
                if (s2 == null) { // 如去掉，A,B都是null，A先进来创建了一个，
                    // 锁给B后，B不用判断null，也会直接创建一个对象
                    s2 = new Singleton2();
                }
            }
        }
        return s2;
    }
}

// why volatile?可以避免重排序，final也可以，禁止cpu的指令集重排序
// 创建对象可以分为3步
// 1 分配内存
// 2 初始化对象
// 3 对象指向刚分配的地址
// 由于cpu的优化，会发生重排序，
// 假设A线程执行了1和3，B线程判断null的时候会返回没有初始化的实例