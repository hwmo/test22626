package com.hwmo.jvm故障诊断与性能优化.chapter8;

public class VolatileTest {
    public static class MyThread extends Thread{
        private volatile boolean stop = false;
        //加上volatile关键字就能让线程停下来，没有就停不下来
        //因为volatile关键字能让变量值的修改可见

        public void stopMe(){
            stop = true;
        }

        @Override
        public void run() {
            int i = 0;
            while (!stop) {
                i++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("MyThread stop!");
            System.out.println("------------i: "+i);
        }
    }
    public static class MyThread2 extends Thread{
        private boolean stop = false;//下面使用synchronized也可以解决可见性问题。让线程停下来

        public synchronized void stopMe(){
            stop = true;
        }
        public synchronized boolean isStop(){
            return stop;
        }

        @Override
        public void run() {
            int i = 0;
            while (!isStop()) {
                i++;
            }
            System.out.println("MyThread2 stop!");
            System.out.println("------------i: "+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(1000);
        myThread.stopMe();
        Thread.sleep(1000);

        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        Thread.sleep(1000);
        myThread2.stopMe();
        Thread.sleep(1000);
    }
}
