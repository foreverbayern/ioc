package com.lm.ioc.context;

import com.lm.ioc.HelloWorldService;
import org.junit.Test;

/**
 * @author:lucky date:2018/9/23
 * time:17:50
 */
public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        HelloWorldService service = (HelloWorldService) applicationContext.getBean("helloWorldService");
        service.helloWorld();
        System.out.println(service.getOutputService());
    }
}
