package com.lm.ioc;

import com.lm.ioc.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:lucky date:2018/9/22
 * time:10:45
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{


    private Map<String,BeanDefinition> registry;

    private ResourceLoader resourceLoader;


    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
