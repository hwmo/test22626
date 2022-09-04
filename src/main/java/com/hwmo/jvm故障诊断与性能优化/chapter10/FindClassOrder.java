package com.hwmo.jvm故障诊断与性能优化.chapter10;

public class FindClassOrder {

    public static void main(String[] args) {
        //-Xbootclasspath/a:D:/test/middleware/clz
        HelloLoader loader = new HelloLoader();
        loader.print();
    }

}
