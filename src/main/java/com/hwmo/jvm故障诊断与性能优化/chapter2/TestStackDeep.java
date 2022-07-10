package com.hwmo.jvm故障诊断与性能优化.chapter2;

public class TestStackDeep {

    public static int count = 0;

    public static void recursion(){
        count++;
        recursion();
    }
    public static void recursion(long a, long b, long c){
        long d=1,e=2,f=3,g=4,h=5,i=6,j=7,k=8;
        count++;
        recursion(a,b,c);
    }
    public static void main(String[] args) {
        try {
//            recursion();//栈默认大小为1m
            recursion(1,1,1);//栈默认大小为1m
        }catch (Throwable e){
            System.out.println("deep of calling1: "+count);
            e.printStackTrace();
        }finally {
            System.out.println("deep of calling2: "+count);
        }
        System.out.println("deep of calling3: "+count);
    }

}
