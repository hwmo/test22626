package com.hwmo.jvm故障诊断与性能优化.chapter2;

public class TestGC {

    public static void main(String[] args) {
        TestGC gc = new TestGC();
        gc.printBase();
        gc.localvarGc1();
    }

    public void localvarGc1(){
        byte[] a = new byte[1300*1024*1024];
        System.gc();
        System.out.println("total heap: "+Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println("free heap: "+Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println("max heap: "+Runtime.getRuntime().maxMemory()/1024/1024);
    }
    public void localvarGc2(){
        byte[] a = new byte[6*1024*1024];
        a = null;
        System.gc();
        System.out.println("total heap: "+Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println("free heap: "+Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println("max heap: "+Runtime.getRuntime().maxMemory()/1024/1024);
    }
    public void localvarGc3(){
        {
            byte[] a = new byte[6 * 1024 * 1024];
        }
        System.gc();
        System.out.println("total heap: "+Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println("free heap: "+Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println("max heap: "+Runtime.getRuntime().maxMemory()/1024/1024);
    }
    public void localvarGc4(){
        {
            byte[] a = new byte[6 * 1024 * 1024];
        }
        int c = 10;
        System.gc();
        System.out.println("total heap: "+Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println("free heap: "+Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println("max heap: "+Runtime.getRuntime().maxMemory()/1024/1024);
    }
    public void localvarGc5(){
        localvarGc1();
        System.gc();
        System.out.println("total heap: "+Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println("free heap: "+Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println("max heap: "+Runtime.getRuntime().maxMemory()/1024/1024);
    }

    public void printBase(){
        System.out.println("total heap: "+Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println("free heap: "+Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println("max heap: "+Runtime.getRuntime().maxMemory()/1024/1024);
    }
}
