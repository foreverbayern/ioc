package com.lm.ioc.context;

import com.lm.ioc.beans.factory.AbstractBeanFactory;

/**
 * @author:lucky date:2018/9/23
 * time:15:59
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory factory;

    public AbstractApplicationContext(AbstractBeanFactory factory) {
        this.factory = factory;
    }

    public void refresh() throws Exception {

    }

    @Override
    public Object getBean(String name) throws Exception {
        return factory.getBean(name);
    }
}
