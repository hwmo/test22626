package com.hwmo.jvm故障诊断与性能优化.chapter11;

public class CalcPi {

    public static double calcpi(){
        double re = 0;
        for(int i = 0; i <10000; i++){
            re+=((i&1) == 0?-1:1)*1.0/(2*i-1);
        }
        return re*4;
    }

    public static void main(String[] args) {
        //解释 -Xint
        //编译 -Xcomp
        //结果：编译执行比解释执行快好几倍
        double pi = 0;
        long start = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            pi = calcpi();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(pi);
    }

}
