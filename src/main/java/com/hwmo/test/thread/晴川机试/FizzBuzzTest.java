package com.hwmo.test.thread.晴川机试;


//给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：
//如果这个数被3整除，打印fizz.
//如果这个数被5整除，打印buzz.
//如果这个数能同时被3和5整除，打印fizz buzz.
//样例
//比如 n = 15, 返回一个字符串数组：
//"1", "2", "fizz","4", "buzz", "fizz","7", "8", "fizz","buzz", "11", "fizz","13", "14", "fizz buzz"

//如果改为用四个线程实现？？？？
//机试地址https://e.leetcode.cn/assessment/qcsoft-0004/login/5467a990-c3f2-4109-8416-8843503e81ed
public class FizzBuzzTest {
    private static int n=15;


    public void printFizz(Runnable fizz, int num){
        if(num % 3 == 0){
            System.out.print("fizz");
        }
    }

    public void printBuzz(Runnable buzz){

    }

    public void printFizzBuzz(Runnable fizzbuzz){

    }

    public void printN(int num){
        System.out.print(num+" ");
    }

    public static void main(String[] args) {
        FizzBuzzTest t = new FizzBuzzTest();
        for(int i = 1; i <= n; i++){
            //t.printN(i);
            if(i%3==0 && i%5==0){
                System.out.print("fizzbuzz ");
            }else if(i%5==0){
                System.out.print("buzz ");
            }else if(i%3==0){
                System.out.print("fizz ");
            }else{
                System.out.print(i+" ");
            }
        }

    }
}
