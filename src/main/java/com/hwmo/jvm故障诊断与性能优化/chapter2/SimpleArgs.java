package com.hwmo.jvm故障诊断与性能优化.chapter2;

public class SimpleArgs {

    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++){
            System.out.println("参数"+(i+1)+":"+args[i]);
        }
        System.out.println("-Xmx"+Runtime.getRuntime().maxMemory()/1024/1024 + "m");
        System.out.println("free:"+Runtime.getRuntime().freeMemory()/1024/1024 + "m");
        System.out.println("total:"+Runtime.getRuntime().totalMemory()/1024/1024 + "m");
    }

}
