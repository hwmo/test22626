package com.hwmo.jvm故障诊断与性能优化.chapter5;

public class UseTLAB {

    //-XX:-UseTLAB -Xcomp -XX:-BackgroundCompilation -XX:-DoEscapeAnalysis -server
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < 10000000; i++){
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void alloc(){
        byte[] b = new byte[2];
        b[0] = 1;
    }
}
