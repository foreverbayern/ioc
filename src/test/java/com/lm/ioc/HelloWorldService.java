package com.lm.ioc;

/**
 * @author:lucky date:2018/9/21
 * time:0:24
 */
public class HelloWorldService {

    private String text;

    public void helloWorld() {
        System.out.println(text);
    }

    public void setText(String text) {
        this.text = text;
    }
}
