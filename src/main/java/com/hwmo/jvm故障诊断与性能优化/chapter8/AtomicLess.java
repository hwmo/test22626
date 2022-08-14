package com.hwmo.jvm故障诊断与性能优化.chapter8;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class AtomicLess {

    private static final int MAX_THREADS = 3;
    private static final int MAX_TASKS = 3;
    private static final int TARGET_COUNT = 10000000;

    //下面三种方式多线程方式读写数据比较，LongAdder性能最好，synchronized最差。
    // （但是，我的电脑跑出来却是AtomicLong比LongAdder好，不知为啥）
    private AtomicLong acount = new AtomicLong(0);
    private long count = 0;
    private LongAdder longAdderCount = new LongAdder();

    static CountDownLatch cdlSync = new CountDownLatch(MAX_TASKS);
    static CountDownLatch cdlAtomic = new CountDownLatch(MAX_TASKS);
    static CountDownLatch cdlAddr = new CountDownLatch(MAX_TASKS);

    protected synchronized long inc(){
        return ++count;
    }
    protected synchronized long getCount(){
        return count;
    }

    public class SyncThread implements Runnable{

        protected long starttime;
        AtomicLess out;

        public SyncThread(AtomicLess o, long starttime){
            out = o;
            this.starttime = starttime;
        }

        @Override
        public void run() {
            long v = out.getCount();
            while (v < TARGET_COUNT){
                v = out.inc();
            }
            long end = System.currentTimeMillis();
            System.out.println("SyncThread spend: "+(end - starttime) + "ms, v="+v);
            cdlSync.countDown();
        }
    }

    public void testSync() throws InterruptedException {
        ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
        long starttime = System.currentTimeMillis();
        SyncThread t = new SyncThread(this, starttime);

        for(int i = 0; i < MAX_TASKS; i++){
            exe.submit(t);
        }
        cdlSync.await();
        exe.shutdown();

    }

    public class AtomicThread implements Runnable{
        protected long starttime;
        public AtomicThread(long starttime){
            this.starttime = starttime;
        }

        @Override
        public void run() {
            long v = acount.get();
            while (v < TARGET_COUNT){
                v = acount.incrementAndGet();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("AtomicThread spend: "+(endTime-starttime)+"ms, v="+v);
            cdlAtomic.countDown();
        }
    }

    public void testAtomic() throws InterruptedException {
        ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
        long starttime = System.currentTimeMillis();
        AtomicThread t = new AtomicThread(starttime);
        for(int i = 0; i < MAX_TASKS; i++){
            exe.submit(t);
        }
        cdlAtomic.await();
        exe.shutdown();
    }

    public class LongAddrThread implements Runnable{

        protected long starttime;

        public LongAddrThread(long starttime){
            this.starttime = starttime;
        }

        @Override
        public void run() {
            long v = longAdderCount.sum();
            while (v < TARGET_COUNT){
                longAdderCount.increment();
                v = longAdderCount.sum();
            }
            long endtime = System.currentTimeMillis();
            System.out.println("LongAddrThread spend: "+(endtime-starttime)+"ms, v="+v);
            cdlAddr.countDown();
        }
    }
    public void testLongAddr() throws InterruptedException {
        ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
        long starttime = System.currentTimeMillis();
        LongAddrThread t = new LongAddrThread(starttime);
        for(int i = 0; i < MAX_TASKS; i++){
            exe.submit(t);
        }
        cdlAddr.await();
        exe.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicLess atomicLess = new AtomicLess();
        atomicLess.testSync();
        atomicLess.testAtomic();
        atomicLess.testLongAddr();
    }

}
