package com.hwmo.jvm故障诊断与性能优化.chapter1;

public class 原码反码补码 {

    //虚拟机规范全文 http://docs.oracle.com/javase/jvms/se7/html
    //java虚拟机中，byte short int long对应8 16 32 64位

    //在JVM中，整数是以补码表示的
    //正数的补码为原码本身，负数补码为反码+1
    //以byte为例10原码为00001010、-10原码为10001010
    //         10反码为00000101、-10反码为11110101
    //         10补码为00001010、-10补码为11110110
    public static void main(String[] args) {

        printINT补码();
        System.out.println();
//        printBYTE补码();

        printFloatInJvm();
    }

//    public static void printBYTE补码(){
//        byte a = -10;
//        for(int i = 0; i < 8; i++){
//            int t = (a & 0x80000000 >>> i) >>> (7-i);//
//            System.out.print(t);
//        }
//    }

    //打印整形在JVM中的表示
    public static void printINT补码(){
        int a = -10;
        for(int i = 0; i < 32; i++){
            int t = (a & 0x80000000 >>> i) >>> (31-i);//
            System.out.print(t);
        }
    }

    //打印浮点型在JVM中的表示
    public static void printFloatInJvm(){
        float a = -5;
        System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(a)));
    }

}
