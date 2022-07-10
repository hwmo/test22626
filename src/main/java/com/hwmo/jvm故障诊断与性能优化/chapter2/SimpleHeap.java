package com.hwmo.jvm故障诊断与性能优化.chapter2;

public class SimpleHeap {

    public int id;
    public SimpleHeap(int id){
        this.id = id;
    }
    public void show(){
        System.out.println("My id is: "+ id);
    }
    public static void main(String[] args) {
        SimpleHeap s1 = new SimpleHeap(1);
        SimpleHeap s2 = new SimpleHeap(2);
        s1.show();
        s2.show();
    }
}
