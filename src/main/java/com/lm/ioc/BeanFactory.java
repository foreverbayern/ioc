package com.lm.ioc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:lucky date:2018/9/21
 * time:0:03
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
