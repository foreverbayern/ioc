package com.lm.ioc.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author:lucky date:2018/9/24
 * time:1:25
 */
public class TimeInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long time = System.nanoTime();
        System.out.println("invocation of method "+methodInvocation.getMethod().getName()+" start!");
        Object result = methodInvocation.proceed();
        System.out.println("invocation of method "+methodInvocation.getMethod().getName()+" end! "+(System.nanoTime()-time)+" nano");
        return result;
    }
}
