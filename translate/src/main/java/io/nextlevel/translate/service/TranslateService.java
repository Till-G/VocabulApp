package io.nextlevel.translate.service;

public class TranslateService {

    private String helloMessage = "Hello, World!";

    public String getHelloMessage(){
        return this.helloMessage;
    }

    public void setHelloMessage(String msg){
        this.helloMessage = msg;
    }
}
