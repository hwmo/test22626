package com.hwmo.jvm故障诊断与性能优化.chapter4;

import java.lang.ref.WeakReference;

public class WeakRef {

    public static void main(String[] args) {
        User user = new User(111, "mhw");
        WeakReference<User> weakReference = new WeakReference<User>(user);
        System.out.println(weakReference.get());//能获取到对象
        user = null;
        System.out.println(weakReference.get());//能获取到对象
        System.gc();
        System.out.println(weakReference.get());//GC时对象被回收了
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
