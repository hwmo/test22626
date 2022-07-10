package com.hwmo.jvm故障诊断与性能优化.chapter4;

public class CanReliveObj {

    public static CanReliveObj obj;

    public static void main(String[] args) throws InterruptedException{
        obj = new CanReliveObj();
        obj = null;
        System.out.println("第1次GC");
        System.gc();
        Thread.sleep(1000);
        if (obj == null) {
            System.out.println("obj is null");
        }else {
            System.out.println("obj is not null");
        }
        System.out.println("第2次GC");
        obj=null;
        System.gc();
        Thread.sleep(1000);
        if (obj == null) {
            System.out.println("obj is null");
        }else {
            System.out.println("obj is not null");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("CanReliveObj finalize called");
        obj = this;//finalize中对象复活
    }

    @Override
    public String toString() {
        return "I am CanReliveObj";
    }
}
