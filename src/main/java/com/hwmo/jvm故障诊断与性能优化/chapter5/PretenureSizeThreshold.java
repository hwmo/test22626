package com.hwmo.jvm故障诊断与性能优化.chapter5;

import java.util.HashMap;
import java.util.Map;

public class PretenureSizeThreshold {

    public static final int _1K = 1024;
    //-XX:PretenureSizeThreshold=1000设置对象直接晋升到老年代的阈值
    //要禁用掉TLAB才能看到对象分配到老年代 -XX:-UseTLAB
    public static void main(String[] args) {
        Map<Integer, byte[]> map = new HashMap<Integer, byte[]>();
        for(int i = 0; i < 5 * _1K; i++){
            byte[] b = new byte[_1K];
            map.put(i, b);
        }
    }

}
