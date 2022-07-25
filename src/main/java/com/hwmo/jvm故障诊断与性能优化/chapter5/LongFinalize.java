package com.hwmo.jvm故障诊断与性能优化.chapter5;

public class LongFinalize {
    public static class LF{
        byte[] content = new byte[512];

        @Override
        protected void finalize() throws Throwable {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath="D:/lf.dump"
        //发生OOM
        long start = System.currentTimeMillis();
        for(int i = 0; i < 50000; i++){
            LF lf = new LF();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
