package com.hwmo.jvm故障诊断与性能优化.chapter8;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest2 {

    private static CountDownLatch countDownLatch = new CountDownLatch(1000);
    private volatile static int num = 0;//用volatile不能保证最后输出num为1000
    private static AtomicInteger atomicNum = new AtomicInteger();//用AtomicInteger能保证最后输出num为1000

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            for(int i = 0; i < 1000; i++) {
                try {
                    num++;
                    atomicNum.getAndIncrement();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
        try{
            countDownLatch.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println(num);
        System.out.println(atomicNum);
    }

}
