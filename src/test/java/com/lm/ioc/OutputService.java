package com.lm.ioc;

import org.junit.Assert;

/**
 * @author:lucky date:2018/9/22
 * time:20:34
 */
public class OutputService {

    private HelloWorldService helloWorldService;

    public void output(String text) {
        Assert.assertNotNull(helloWorldService);
        System.out.println(text);
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
