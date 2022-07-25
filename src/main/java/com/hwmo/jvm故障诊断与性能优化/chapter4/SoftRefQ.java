package com.hwmo.jvm故障诊断与性能优化.chapter4;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class SoftRefQ {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("maxMem: "+Runtime.getRuntime().maxMemory()/1024/1024+"m");
        System.out.println("freeMem: "+Runtime.getRuntime().freeMemory()/1024/1024+"m");
        System.out.println("totalMem: "+Runtime.getRuntime().totalMemory()/1024/1024+"m");
        Thread t = new CheckReferenceQueue();
        t.setDaemon(true);
        t.start();
        User user = new User(111, "mhw");
        queue = new ReferenceQueue<User>();
        UserSoftReference userSoftReference = new UserSoftReference(user, queue);
        user = null;
        System.out.println(userSoftReference.get());
        System.gc();
        System.out.println("After GC:");
        System.out.println(userSoftReference.get());//内存充足，不会被回收

        System.out.println("Try to create byte array and GC");
        byte[] b = new byte[1024 * 925 * 7];
        System.gc();
        System.out.println(userSoftReference.get());//内存紧张，被回收了
        Thread.sleep(1000);

        System.out.println("maxMem: "+Runtime.getRuntime().maxMemory()/1024/1024+"m");
        System.out.println("freeMem: "+Runtime.getRuntime().freeMemory()/1024/1024+"m");
        System.out.println("totalMem: "+Runtime.getRuntime().totalMemory()/1024/1024+"m");
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

    public static ReferenceQueue queue;

    public static class CheckReferenceQueue extends Thread{
        @Override
        public void run() {
            while (true){
                if(queue != null){
                    UserSoftReference obj = null;
                    try {
                        obj = (UserSoftReference) queue.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(obj != null){
                        System.out.println("user id " +obj.uid+ " is delete");
                    }
                }
            }
        }
    }

    public static class UserSoftReference extends SoftReference<User> {
        int uid;
        public UserSoftReference(User referent, ReferenceQueue<? super User> q) {
            super(referent, q);
            uid = referent.id;
        }
    }

}
