package com.hwmo.jvm故障诊断与性能优化.chapter10;

public class PrintClassLoaderTree {

    public static void main(String[] args) {
        ClassLoader cl = PrintClassLoaderTree.class.getClassLoader();
        //AppClassLoader（应用类加载器）->ExtClassLoader(扩展类加载器)->启动类加载器（纯c语言实现，无法获得其ClassLoader实例）
        while (cl != null) {
            System.out.println(cl);
            cl = cl.getParent();
        }
    }
}
