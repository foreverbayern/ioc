package com.lm.ioc.factory;

import com.lm.ioc.BeanDefinition;


/**
 * @author:lucky date:2018/9/21
 * time:0:03
 */
public interface BeanFactory {

    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
