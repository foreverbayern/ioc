package com.lm.ioc;

import com.lm.ioc.beans.BeanDefinition;
import com.lm.ioc.beans.factory.AbstractBeanFactory;
import com.lm.ioc.beans.factory.AutowireCapableBeanFactory;
import com.lm.ioc.beans.factory.BeanFactory;
import com.lm.ioc.beans.io.ResourceLoader;
import com.lm.ioc.beans.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * @author:lucky date:2018/9/21
 * time:0:25
 */
public class BeanFactoryTest {

    @Test
    //懒加载
    public void test() throws Exception {
        //1.读取配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
        reader.loadBeanDefinitions("ioc.xml");

        //2.初始化BeanFactory并注册bean
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> entry : reader.getRegistry().entrySet()) {
        }

        //3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
        OutputService outputService = helloWorldService.getOutputService();
        System.out.println(outputService);
    }


    @Test
    public void testPreInstantiate() throws Exception {
        //1.读取配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
        reader.loadBeanDefinitions("ioc.xml");
        //2.初始化BeanFacotry并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> entry : reader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(entry.getKey(),entry.getValue());
        }

        //初始化bean
        beanFactory.preInstantiateSingletons();

        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
