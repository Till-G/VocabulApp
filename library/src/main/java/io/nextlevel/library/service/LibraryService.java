package io.nextlevel.library.service;

public class LibraryService {

    private String helloMessage = "Hello, World!";

    private String library = "This is the library-Site";

    public String getHelloMessage(){
        return this.helloMessage;
    }
    public String getLibrary(){
        return this.library;
    }

    public void setHelloMessage(String msg){
        this.helloMessage = msg;
    }
    public void setLibrary(String text){
        this.library = text;
    }
}
