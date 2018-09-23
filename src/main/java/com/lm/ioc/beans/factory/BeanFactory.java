package com.lm.ioc.beans.factory;



/**
 * @author:lucky date:2018/9/21
 * time:0:03
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

}
