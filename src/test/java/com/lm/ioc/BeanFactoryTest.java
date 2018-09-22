package com.lm.ioc;

import com.lm.ioc.factory.AutowireCapableBeanFactory;
import com.lm.ioc.factory.BeanFactory;
import com.lm.ioc.io.ResourceLoader;
import org.junit.Test;

import java.util.Map;

/**
 * @author:lucky date:2018/9/21
 * time:0:25
 */
public class BeanFactoryTest {

    @Test
    public void test() throws Exception {
        //1.读取配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
        reader.loadBeanDefinitions("ioc.xml");

        //初始化beanfactory并注册bean
        BeanFactory factory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> definitionEntry : reader.getRegistry().entrySet()) {
            factory.registerBeanDefinition(definitionEntry.getKey(),definitionEntry.getValue());
        }

        //获取bean
        HelloWorldService service = (HelloWorldService) factory.getBean("helloWorldService");
        service.helloWorld();
    }
}
