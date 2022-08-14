package com.hwmo.jvm故障诊断与性能优化.chapter8;

import java.util.List;
import java.util.Vector;

public class Biased {

    public static List<Integer> numberList = new Vector<>();
//-Xms512m -Xmx512m -client -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0
    //开启偏向锁-XX:+UseBiasedLocking，对性能有一定的提升
    //偏向锁在竞争激烈的的场合没有太强的优化效果
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int count = 0;
        int startnum = 0;
        while (count < 10000000){
            numberList.add(startnum);
            startnum+=2;
            count++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
