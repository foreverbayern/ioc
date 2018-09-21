package com.lm.ioc;

import com.lm.ioc.factory.AutowireCapableBeanFactory;
import com.lm.ioc.factory.BeanFactory;
import org.junit.Test;

/**
 * @author:lucky date:2018/9/21
 * time:0:25
 */
public class BeanFactoryTest {

    @Test
    public void test() {
        BeanFactory factory = new AutowireCapableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.lm.ioc.HelloWorldService");
        factory.registerBeanDefinition("helloWorldService", beanDefinition);

        HelloWorldService helloWorldService = (HelloWorldService) factory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
