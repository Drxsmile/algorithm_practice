package com.snx;


public class Singleton3 {
    private static class SingletonHolder{
        private static final Singleton3 s3 = new Singleton3();
    }
    private Singleton3(){

    }
    public static final Singleton3 getInstance(){
        return SingletonHolder.s3;
    }
}
