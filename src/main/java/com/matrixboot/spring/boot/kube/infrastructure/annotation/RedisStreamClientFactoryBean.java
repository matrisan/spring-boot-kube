package com.matrixboot.spring.boot.kube.infrastructure.annotation;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/**
 * <p>
 * create in 2021/12/14 10:52 PM
 *
 * @author shishaodong
 * @version 0.0.1
 */
public class RedisStreamClientFactoryBean implements FactoryBean<Object>, InitializingBean, ApplicationContextAware, BeanFactoryAware {

    private BeanFactory beanFactory;

    private Class<?> type;

    private String name;

    private String encode;

    private InvocationHandlerFactory factory = new InvocationHandlerFactory.Default();

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object getObject() {
        Target<?> target = new HardCodedTarget<>();
        InvocationHandler handler = factory.create(target, new HashMap<>());
        return Proxy.newProxyInstance(type.getClassLoader(), new Class<?>[]{type}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return type;
    }

    @Override
    public void afterPropertiesSet() {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

}
