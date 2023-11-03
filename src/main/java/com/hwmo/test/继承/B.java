package com.hwmo.test.继承;

public class B extends A{

    static {
        System.out.println("B static");
    }

    public B(){
        System.out.println("B");
    }


    public static void main(String[] args) {
        A b = new B();//验证代码执行顺序
    }

}
