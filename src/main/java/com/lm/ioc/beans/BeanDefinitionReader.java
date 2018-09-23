package com.lm.ioc.beans;

/**
 * @author:lucky date:2018/9/22
 * time:10:42
 *
 * 读配置
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
