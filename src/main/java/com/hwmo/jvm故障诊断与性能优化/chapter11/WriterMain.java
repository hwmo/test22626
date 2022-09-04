package com.hwmo.jvm故障诊断与性能优化.chapter11;

public class WriterMain {

    public static void main(String[] args) throws InterruptedException {
        //-XX:+PrintCompilation -server -Xcomp
        //-XX:+PrintCompilation -server -Xcomp -XX:+TieredCompilation    打开多级编译器
        long start = System.currentTimeMillis();
        WriterService writerService = new WriterService();
        for (int i = 0; i < 20000000; i++){
            writerService.service();
        }
        long end = System.currentTimeMillis();
        System.out.println("spend:"+(end-start));
        writerService=null;
        System.gc();
        Thread.sleep(5000);
    }

}

class WriterService{
    public void service(){
        DBWriter writer = new DBWriter();
        writer.writer();
    }
}

class DBWriter{
    public void writer(){
        "DBWriter".toCharArray();
    }
}
