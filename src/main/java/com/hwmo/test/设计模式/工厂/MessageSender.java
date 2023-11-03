package com.hwmo.test.设计模式.工厂;

public class MessageSender implements Sender{

    @Override
    public void send() {
        System.out.println("-------------messagesend");
    }
}
