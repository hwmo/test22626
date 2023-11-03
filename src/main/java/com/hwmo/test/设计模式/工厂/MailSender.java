package com.hwmo.test.设计模式.工厂;

public class MailSender implements Sender{


    @Override
    public void send() {
        System.out.println("----------mailsend");
    }
}
