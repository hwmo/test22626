package com.hwmo.jvm故障诊断与性能优化.chapter2;

import java.util.HashMap;

public class PermTest {

    public static void main(String[] args) {
        int i = 0;
        try{
            for(i=0; i < 100000; i++){
                //动态生成类实例
                //CglibBean bean = new CglibBean("geym.zbase.ch2.perm"+i,new HashMap());
                PermTest2 t2 = new PermTest2();
            }
        }catch (Exception e){
            System.out.println("total create count:"+i);
        }
    }

    static class PermTest2{

    }

}
