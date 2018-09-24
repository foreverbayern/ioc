package com.lm.ioc.aop;

/**
 * @author:lucky date:2018/9/24
 * time:0:02
 */
public class TargetSource {


    private Class targetClass;
    private Object target;

    public TargetSource(Class targetClass, Object target) {
        this.targetClass = targetClass;
        this.target = target;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }
}
