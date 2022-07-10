package com.hwmo.jvm故障诊断与性能优化.chapter3;

import java.nio.ByteBuffer;

/**
 * JVM申请直接内存比申请堆内存慢
 */
public class AllocDirectBuffer {

    public static void main(String[] args) {
        directAllocate();
        heapAllocate();

        directAllocate();
        heapAllocate();
    }

    public static void directAllocate(){
        long start = System.currentTimeMillis();
        for(int i = 0; i<200000; i++){
            ByteBuffer b = ByteBuffer.allocateDirect(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("directAllocatetime: "+(end-start));
    }

    public static void heapAllocate(){
        long start = System.currentTimeMillis();
        for(int i = 0; i<200000; i++){
            ByteBuffer b = ByteBuffer.allocate(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("heapAllocatetime: "+(end-start));
    }
}
