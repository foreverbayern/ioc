package com.lm.ioc.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author:lucky date:2018/9/24
 * time:0:01
 */
public class JdkDynamicAopProxy implements AopProxy,InvocationHandler {


    private AdvisedSupport advisedSupport;

    public JdkDynamicAopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(),new Class[]{
                advisedSupport.getTargetSource().getTargetClass()
        },this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(advisedSupport.getTargetSource());
        System.out.println(proxy.getClass().getName());

        MethodInterceptor methodInterceptor = advisedSupport.getMethodInterceptor();
        return methodInterceptor.invoke(new ReflectiveMethodInvocation(advisedSupport.getTargetSource().getTarget(),
                method, args));
    }
}
