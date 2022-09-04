package com.hwmo.jvm故障诊断与性能优化.chapter11;


//该例子说明什么是方法内联
public class InLineMain {

    static int i = 0;

    public static void inc(){
        i++;
    }

    public static void main(String[] args) {
        //-XX:+Inline打开方法内联
        //-Xcomp -server -XX:+Inline
        //-Xcomp -server -XX:-Inline
        //比较上面两种参数的运行时间
        //inc()函数内容较少，调用一次的成本相对比较高，对其进行内联，循环体内变成i++
        long start = System.currentTimeMillis();
        for(int j = 0; j < 1000000000; j++){
            inc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

}
