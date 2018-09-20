package com.lm.ioc;

import org.junit.Test;

/**
 * @author:lucky date:2018/9/21
 * time:0:25
 */
public class BeanFactoryTest {

    @Test
    public void test() {
        BeanFactory factory = new BeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
        factory.registerBeanDefinition("helloWorldService", beanDefinition);

        //获取bean
        HelloWorldService helloWorldService = (HelloWorldService) factory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
