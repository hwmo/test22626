package com.hwmo.jvm故障诊断与性能优化.chapter2;

public class AllocationTest {

    public static void main(String[] args) {
        //方法的调用只消耗栈空间，跟堆没关系
        System.out.println("total heap: "+Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println("free heap: "+Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println("max heap: "+Runtime.getRuntime().maxMemory()/1024/1024);

        hello1();



    }

    public static void hello1(){
        System.out.println("---------hello1");
        System.out.println("total heap: "+Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println("free heap: "+Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println("max heap: "+Runtime.getRuntime().maxMemory()/1024/1024);
    }
    public static void hello2(){
        System.out.println("---------hello2");
    }
    public static void hello3(){
        System.out.println("---------hello3");
    }
    public static void hello4(){
        System.out.println("---------hello4");
    }
    public static void hello5(){
        System.out.println("---------hello5");
    }

}
