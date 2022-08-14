package com.hwmo.jvm故障诊断与性能优化.chapter8;

public class MultiThreadVolatileLong {

    public static volatile long t=0;//volatile关键字使变量保持原子操作。多个线程对变量t确保原子操作，它的值必是4个中之一
    //public static long t=0;//不加volatile，在64位系统中可能出现一个线程在写long型数据中32位，而另外一个线程写了long型数据中的另外32位

    public static class ChangeT implements Runnable{
        private long to;
        public ChangeT(long to){
            this.to = to;
        }

        @Override
        public void run() {
            while (true){
                MultiThreadVolatileLong.t = to;
                Thread.yield();
            }
        }
    }

    public static class ReadT implements Runnable{
        @Override
        public void run() {
            while (true){
                long tmp = MultiThreadVolatileLong.t;
                if(tmp != 111 && tmp != -999 && tmp != 333 && tmp != -444)
                    System.out.println(tmp);
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ChangeT(111)).start();
        new Thread(new ChangeT(-999)).start();
        new Thread(new ChangeT(333)).start();
        new Thread(new ChangeT(-444)).start();
        new Thread(new ReadT()).start();
    }

}
