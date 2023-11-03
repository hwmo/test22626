package com.hwmo.test.设计模式.工厂;

public class SenderFactory {

    public Sender producer(String type){
        if("mail".equals(type)){
            return new MailSender();
        }else if("message".equals(type)){
            return new MessageSender();
        }else{
            System.out.println("error type");
            return null;
        }
    }

    //下面也可以对种产品单独设一个方法，叫作多个工厂模式，或在下面的方法加修饰符static，叫做静态工厂模式
    //同理，将工厂类抽象成一个接口，让各自去实现创建产口的方法，就称为抽象工厂模式
    public Sender producerMail(){
        return new MailSender();
    }
    public Sender producerSms(){
        return new MessageSender();
    }
}
