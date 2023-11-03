package com.hwmo.test.设计模式.singleton;


//单例模式详见博文https://baijiahao.baidu.com/s?id=1771654313513263168&wfr=spider&for=pc
public class SingletonTest1 {

    private static SingletonTest1 instance = null;//懒汉模式，因为一开始不创建，所以叫懒汉

    private SingletonTest1(){
        //私有构造方法
    }

    public static SingletonTest1 getInstance(){
        if(instance == null){
            instance = new SingletonTest1();
        }
        return instance;
    }

}
