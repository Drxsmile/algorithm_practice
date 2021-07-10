package com.snx;

// 单例模式为什么存在？
// 想要对同一个对象进行操作，比如计数器，配置文件
// 或者一个类实例化比较耗费资源且可重复利用，比如在我的项目里需要与aws进行连接的客户端
// hungry 线程安全
public class Singleton1 {
    // 因为要被静态方法返回，那这样直接通过类调用静态成员也可以
    // 私有是因为我们想要通过访问来获取，对对象可控，可以在方法里加一些条件
    // final？避免被修改
    private static final Singleton1 s1 = new Singleton1();
    // 私有不让别人创建对象，只有我这个类能创建
    private Singleton1(){

    }
    // 外面没有这个类的实例，不是static就无法调用，就可以用类来调用
    public static Singleton1 getInstance(){
        return s1;
    }
}
