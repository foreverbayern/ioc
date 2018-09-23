package com.lm.ioc.beans.factory;

import com.lm.ioc.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:lucky date:2018/9/21
 * time:0:50
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> definitionMap = new ConcurrentHashMap<>();

    private final List<String> beanDefinitionNames = new ArrayList<>();

    @Override
    public Object getBean(String name) throws Exception{
        BeanDefinition beanDefinition = definitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No beans named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        definitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    public void preInstantiateSingletons() throws Exception {
        Iterator<String> it = this.beanDefinitionNames.iterator();
        for (; it.hasNext();) {
            String next = it.next();
            getBean(next);
        }
    }

    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
