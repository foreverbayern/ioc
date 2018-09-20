package com.lm.ioc;

/**
 * @author:lucky date:2018/9/21
 * time:0:06
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
