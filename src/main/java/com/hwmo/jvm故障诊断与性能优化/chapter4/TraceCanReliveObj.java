package com.hwmo.jvm故障诊断与性能优化.chapter4;

import org.junit.platform.commons.util.ToStringBuilder;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class TraceCanReliveObj {

    public static TraceCanReliveObj obj;
    static ReferenceQueue<TraceCanReliveObj> queue;
    public static class CheckRefQueue extends Thread{
        @Override
        public void run() {
            while (true){
                if(queue != null){
                    PhantomReference<TraceCanReliveObj> phantomReference = null;
                    try {
                        phantomReference = (PhantomReference<TraceCanReliveObj>) queue.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(phantomReference != null){
                        System.out.println("TraceCanReliveObj is delete");
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new CheckRefQueue();
        t.setDaemon(true);
        t.start();
        obj = new TraceCanReliveObj();
        queue = new ReferenceQueue<>();
        PhantomReference<TraceCanReliveObj> phantomReference = new PhantomReference<>(obj, queue);
        obj = null;
        System.gc();
        Thread.sleep(1000);
        //对象复活
        if (obj == null) {
            System.out.println("obj is null");
        }else{
            System.out.println("obj is not null");
        }
        System.out.println("第二次GC");
        obj = null;
        System.gc();
        Thread.sleep(1000);
        //第二次GC对象无法复活，因为finalize只能被调用一次，引用队列捕捉到对象被回收
        if (obj == null) {
            System.out.println("obj is null");
        }else{
            System.out.println("obj is not null");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("TraceCanReliveObj finalize called");
        obj = this;
    }

    @Override
    public String toString() {
        return "I am TraceCanreliveObj.";
    }


}
