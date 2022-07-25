package com.hwmo.jvm故障诊断与性能优化.chapter5;

public class AllocEden {

    public static final int size_1K = 1024;

    public static void main(String[] args) {
        for(int i = 0; i < 5*size_1K; i++){
            byte[] b = new byte[size_1K];//from to tenured均未被使用
        }
    }

}
