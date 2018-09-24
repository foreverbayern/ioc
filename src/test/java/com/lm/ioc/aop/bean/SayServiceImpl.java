package com.lm.ioc.aop.bean;

/**
 * @author:lucky date:2018/9/24
 * time:2:08
 */
public class SayServiceImpl implements SayService {

    @Override
    public void say() {
        System.out.println("say ni hao");
    }
}
