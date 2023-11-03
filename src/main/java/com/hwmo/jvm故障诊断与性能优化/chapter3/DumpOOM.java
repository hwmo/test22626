package com.hwmo.jvm故障诊断与性能优化.chapter3;

import java.util.Vector;

public class DumpOOM {

    public static void main(String[] args) {
        //堆溢出演示 -Xms20m -Xmx20m    -Xmx20m加到-Xmx27m时才不会抛OOM
        //-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=log/a.dump
        Vector v = new Vector();
        for(int i =0; i < 25; i++){
            v.add(new byte[1024 * 1024]);
        }
    }

}
