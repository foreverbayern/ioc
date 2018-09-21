package com.lm.ioc.factory;

import com.lm.ioc.BeanDefinition;
import com.lm.ioc.PropertyValue;

import java.lang.reflect.Field;

/**
 * @author:lucky date:2018/9/21
 * time:12:00
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException {
        return beanDefinition.getBeanClass().newInstance();
    }

    /**
     * 设置属性
     * @param bean
     * @param mbd
     * @throws NoSuchFieldException
     */
    protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws NoSuchFieldException, IllegalAccessException {
        for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValueList()) {
            Field field = bean.getClass().getDeclaredField(propertyValue.getName());
            field.setAccessible(true);
            field.set(bean,propertyValue.getValue());
        }
    }
}
