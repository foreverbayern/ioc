package com.lm.ioc.factory;

import com.lm.ioc.BeanDefinition;

/**
 * @author:lucky date:2018/9/21
 * time:12:00
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try{
            Object bean = beanDefinition.getBeanClass().newInstance();
            return bean;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
