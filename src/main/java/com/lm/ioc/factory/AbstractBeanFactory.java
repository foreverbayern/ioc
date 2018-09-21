package com.lm.ioc.factory;

import com.lm.ioc.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:lucky date:2018/9/21
 * time:0:50
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> definitionMap = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String name) {
        return definitionMap.get(name).getBean();
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        definitionMap.put(name, beanDefinition);
    }

    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException, NoSuchFieldException;
}
