package com.hwmo.test.设计模式.工厂;

public class FactoryTest {


    public static void main(String[] args) {
        SenderFactory factory = new SenderFactory();
        Sender sender = factory.producer("mail");
        sender.send();
    }

}
