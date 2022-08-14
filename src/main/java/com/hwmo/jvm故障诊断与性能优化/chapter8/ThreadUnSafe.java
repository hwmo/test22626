package com.hwmo.jvm故障诊断与性能优化.chapter8;

import java.util.ArrayList;
import java.util.List;

public class ThreadUnSafe {

    public static List<Integer> numberList = new ArrayList<Integer>();
    public static class AddList implements Runnable{
        int startnum = 0;
        public AddList(int startnum){
            this.startnum = startnum;
        }

        @Override
        public void run() {
            int count = 0;
            while (count < 1000000){
                numberList.add(startnum);
                startnum+=2;
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new AddList(0));
        Thread t2 = new Thread(new AddList(1));
        t1.start();
        t2.start();
    }

}
