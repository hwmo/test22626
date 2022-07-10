package com.hwmo.jvm故障诊断与性能优化.chapter2;

public class OnStackTest {

    //演示非逃逸对象的栈上分配
    public static void main(String[] args) {
        //-server -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-UseTLAB -XX:+EliminateAllocations
        //关闭逃逸分析DoEscapeAnalysis和标题替换（允许将对象打散分配在栈上）EliminateAllocations参数中的任何一个，就会有大量的GC日志
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1000000000; i++){
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static class User{
        public int id=0;
        public String name = "";
    }
//    private static User u;
    public static void alloc(){
        User u = new User();
//        u = new User();
        u.id=1;
        u.name="mhw";
    }

}
