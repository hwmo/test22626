package com.hwmo.jvm故障诊断与性能优化.chapter5;

import java.util.HashMap;
import java.util.Map;

public class MaxTenuringThreshold {

    public static final int size_1M = 1024*1024;
    public static final int size_1K = 1024;
//-Xms1024m -Xmx1024m -XX:+PrintGCDetails -XX:MaxTenuringThreshold=5 -XX:+PrintHeapAtGC
    //eden区的对象经过MaxTenuringThreshold次GC进入老年代
    public static void main(String[] args) {
        Map<Integer, byte[]> map = new HashMap<>();
        for(int i =0; i < 5*size_1K; i++){
            byte[] b = new byte[size_1K];
            map.put(i, b);
        }
        for(int k = 0; k < 17; k++){
            for(int i = 0; i < 270; i++){
                byte[] g = new byte[size_1M];
            }
        }
    }

}
