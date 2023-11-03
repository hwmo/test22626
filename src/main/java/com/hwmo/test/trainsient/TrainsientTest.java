package com.hwmo.test.trainsient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class TrainsientTest {

    public static void main(String[] args) {
        LoggingInfo logInfo = new LoggingInfo("MIKE", "MECHANICS");
        System.out.println(logInfo.toString());
        try {
            ObjectOutputStream o = new ObjectOutputStream(
                    new FileOutputStream("d:/test/logInfo.out"));
            o.writeObject(logInfo);
            o.close();
        } catch (Exception e) {//deal with exception
            //To read the object back, we can write
            e.printStackTrace();
        }
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("d:/test/logInfo.out"));
            LoggingInfo logInfo1 = (LoggingInfo) in.readObject();
            System.out.println(logInfo1.toString());//pwd属性被transient修饰，不能被反序列化出来
        } catch (Exception e1) {//deal with exception
            e1.printStackTrace();
        }
    }
}
class LoggingInfo implements java.io.Serializable
{
    private Date loggingDate = new Date();
    private String uid;
    //private String pwd;
    private transient String pwd;

    LoggingInfo(String user, String password)
    {
        uid = user;
        pwd = password;
    }
    public String toString()
    {
        String password=null;
        if(pwd == null)
        {
            password = "NOT SET";
        }
        else
        {
            password = pwd;
        }
        return "user: " + uid +
                ", logging date : " + loggingDate.toString() +
                ", password: " + password;
    }
}