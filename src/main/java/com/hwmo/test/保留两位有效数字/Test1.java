package com.hwmo.test.保留两位有效数字;

import java.math.BigDecimal;

public class Test1 {

    public static void main(String[] args) {
        double d = 11;
        double d2 = 3;
        double result = d/d2;
        //保留两位有效数字
        double val = BigDecimal.valueOf(result).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(val);
    }
}
