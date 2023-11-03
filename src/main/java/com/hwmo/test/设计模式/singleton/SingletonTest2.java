package com.hwmo.test.设计模式.singleton;

public class SingletonTest2 {

    private static SingletonTest2 instance = new SingletonTest2();//饿汉模式，因为一开始就创建，所以叫饿汉

    private SingletonTest2(){
        //私有构造方法
    }

    public static synchronized SingletonTest2 getInstance(){
        return instance;
    }

}
