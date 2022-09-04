package com.hwmo.jvm故障诊断与性能优化.chapter11;

public class JITSimpleTest {

    //-XX:CompileThreshold=500 -XX:+PrintCompilation
    //设置CompileThreshold=500 met就会被编译为机器码，（不设置就不会?）
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 500; i++){
            met();
        }
        Thread.sleep(1000);
    }
    public static void met(){
        int a=0,b=0;
        b=a+b;
    }

}
