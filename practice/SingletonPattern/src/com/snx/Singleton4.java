package com.snx;

// 枚举，本身也是一个class类，不会被反射机制破坏
// 反射可以在运行时类信息中获取构造器，然后通过构造器构建对象，
// 反射无法获取枚举类型的构造器，枚举本身也可以保证线程安全，但是不能懒加载
public enum Singleton4 {
    s4;
    public Singleton4 getInstance(){
        return s4;
    }
}
