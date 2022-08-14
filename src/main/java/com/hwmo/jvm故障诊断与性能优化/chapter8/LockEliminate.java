package com.hwmo.jvm故障诊断与性能优化.chapter8;

//锁消除
public class LockEliminate {

    private static final int CIRCLE = 2000000;

    //-server -XX:+DoEscapeAnalysis -XX:+EliminateLocks -Xcomp -XX:-BackgroundCompilation -XX:BiasedLockingStartupDelay=0
    //下面的代码开启锁消除对性能有一点改善-XX:+EliminateLocks
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < CIRCLE; i++){
            createStringBuffer("JVM", "Diagnosis");
        }
        long end = System.currentTimeMillis();
        System.out.println("createStringBuffer cost: " + (end-start) + "ms");
    }
    public static String createStringBuffer(String s1, String s2){
        StringBuffer sb = new StringBuffer();
        sb.append(s1);
        sb.append(s2);
        return sb.toString();
    }

}
