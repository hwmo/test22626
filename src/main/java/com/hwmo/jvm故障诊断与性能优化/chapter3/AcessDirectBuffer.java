package com.hwmo.jvm故障诊断与性能优化.chapter3;

import java.nio.ByteBuffer;

/**
 * JVM直接内存访问和堆内存访问速度比较
 * -server模式比较-client模式更快
 */
public class AcessDirectBuffer {

    public static void main(String[] args) {
        directAccess();
        heapAccess();

        directAccess();
        heapAccess();
    }

    public static void directAccess(){
        long start = System.currentTimeMillis();
        ByteBuffer b = ByteBuffer.allocateDirect(500);
        for(int i = 0; i<100000; i++){
            for(int j = 0; j < 99; j++){
                b.putInt(j);
            }

            b.flip();

            for(int j = 0; j < 99; j++)
                b.getInt();
            b.clear();
        }
        long end = System.currentTimeMillis();
        System.out.println("directwritetime: "+(end-start));
    }

    public static void heapAccess(){
        long start = System.currentTimeMillis();
        ByteBuffer b = ByteBuffer.allocate(500);
        for(int i = 0; i<100000; i++){
            for(int j = 0; j < 99; j++){
                b.putInt(j);
            }
            b.flip();
            for(int j = 0; j < 99; j++)
                b.getInt();
            b.clear();
        }
        long end = System.currentTimeMillis();
        System.out.println("heapwritetime: "+(end-start));
    }
}
