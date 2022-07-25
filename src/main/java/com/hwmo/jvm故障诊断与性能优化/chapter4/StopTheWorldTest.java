package com.hwmo.jvm故障诊断与性能优化.chapter4;

import java.util.HashMap;
import java.util.Map;

public class StopTheWorldTest {

    public static void main(String[] args) {
        MyThread m = new MyThread();
        PrintThread p = new PrintThread();
        m.start();
        p.start();
    }
    public static class MyThread extends Thread{
        Map map = new HashMap<>();
        @Override
        public void run() {
            while (true) {
                if(map.size()*512/2014/1024 > 50){
                    map.clear();
                    System.out.println("map clear up");
                }
                byte[] b;
                for(int i = 0; i < 100; i++){
                    b = new byte[512];
                    map.put(System.nanoTime(), b);
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class PrintThread extends Thread{
        long start = System.currentTimeMillis();
        @Override
        public void run() {
            while (true) {
                long end = System.currentTimeMillis();
                long t = end - start;
                long tem = t%1000;
                String point = ".";
                if(tem < 10){
                    point = ".00";
                }else if(tem < 100){
                    point = ".0";
                }
                System.out.println(t/1000 + point + t%1000);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
