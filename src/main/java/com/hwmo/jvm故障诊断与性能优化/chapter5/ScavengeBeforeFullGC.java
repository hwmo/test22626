package com.hwmo.jvm故障诊断与性能优化.chapter5;

public class ScavengeBeforeFullGC {

    public static void main(String[] args) {
        System.gc();//使用并行回收器UseParallelOldGC，触发FULL gC之前，进行了一次新生代GC
    }

}
