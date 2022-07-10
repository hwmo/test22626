package com.hwmo.jvm故障诊断与性能优化.chapter3;

public class HeapAlloc {

    public static void main(String[] args) {
        System.out.println("maxMem: "+Runtime.getRuntime().maxMemory()/1024/1024+"m");
        System.out.println("freeMem: "+Runtime.getRuntime().freeMemory()/1024/1024+"m");
        System.out.println("totalMem: "+Runtime.getRuntime().totalMemory()/1024/1024+"m");

        byte[] b = new byte[1024 * 1024];
        System.out.println("分配了1MB空间给数组");

        System.out.println("maxMem: "+Runtime.getRuntime().maxMemory()/1024/1024+"m");
        System.out.println("freeMem: "+Runtime.getRuntime().freeMemory()/1024/1024+"m");
        System.out.println("totalMem: "+Runtime.getRuntime().totalMemory()/1024/1024+"m");

//        b = new byte[4 * 1024 * 1024];
//        System.out.println("分配了4MB空间给数组");
//
//        System.out.println("maxMem: "+Runtime.getRuntime().maxMemory()/1024/1024+"m");
//        System.out.println("freeMem: "+Runtime.getRuntime().freeMemory()/1024/1024+"m");
//        System.out.println("totalMem: "+Runtime.getRuntime().totalMemory()/1024/1024+"m");
    }

}
