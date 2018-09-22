package com.lm.ioc;

/**
 * @author:lucky date:2018/9/21
 * time:0:24
 */
public class HelloWorldService {

    private String text;

    private OutputService outputService;

    public void helloWorld() {
        System.out.println(text);
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }

    public void setText(String text) {
        this.text = text;
    }

    public OutputService getOutputService() {
        return outputService;
    }
}
