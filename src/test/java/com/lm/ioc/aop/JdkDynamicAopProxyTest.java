package com.lm.ioc.aop;

import com.lm.ioc.HelloWorldService;
import com.lm.ioc.aop.bean.SayService;
import com.lm.ioc.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author:lucky date:2018/9/24
 * time:1:41
 */
public class JdkDynamicAopProxyTest {

    @Test
    public void test() throws Exception{
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        SayService sayService = (SayService) applicationContext.getBean("sayService");
        sayService.say();

        //1.设置被代理对象
        AdvisedSupport support = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(SayService.class, sayService);
        support.setTargetSource(targetSource);

        //2.设置拦截器
        TimeInterceptor interceptor = new TimeInterceptor();
        support.setMethodInterceptor(interceptor);

        //3.创建代理
        JdkDynamicAopProxy proxy = new JdkDynamicAopProxy(support);
        SayService newProxy = (SayService) proxy.getProxy();
        newProxy.say();
    }
}
