package com.hwmo.jvm故障诊断与性能优化.chapter4;

import java.lang.ref.SoftReference;

public class SoftRef {

    public static void main(String[] args) {
        User u = new User(1, "mhw");
        SoftReference<User> userSoftReference = new SoftReference<>(u);
        u = null;
        System.out.println(userSoftReference.get());
        System.gc();
        System.out.println("After GC:");
        System.out.println(userSoftReference.get());

        byte[] b = new byte[1024*925*7];//申请不到7M的空间
        System.gc();
        System.out.println(userSoftReference.get());//由于内存紧张，软引用被清除回收
    }

    public static class User{
        public User(int id, String name){
            this.id = id;
            this.name = name;
        }
        public int id;
        public String name;

        @Override
        public String toString() {
            return "[id="+id+",name="+name+"]";
        }
    }
}
