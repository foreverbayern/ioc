package com.lm.ioc.context;

import com.lm.ioc.beans.BeanDefinition;
import com.lm.ioc.beans.factory.AbstractBeanFactory;
import com.lm.ioc.beans.factory.AutowireCapableBeanFactory;
import com.lm.ioc.beans.io.ResourceLoader;
import com.lm.ioc.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author:lucky date:2018/9/23
 * time:16:30
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;


    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory factory) throws Exception {
        super(factory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
        reader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> entry : reader.getRegistry().entrySet()) {
            factory.registerBeanDefinition(entry.getKey(),entry.getValue());
        }
    }
}
