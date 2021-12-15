package com.matrixboot.spring.boot.kube.infrastructure.annotation;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * TODO
 * <p>
 * create in 2021/12/15 12:15 AM
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface InvocationHandlerFactory {

    InvocationHandler create(Target<?> target, Map<Method, InvocationHandlerFactory.MethodHandler> dispatch);

    /**
     * Like {@link InvocationHandler#invoke(Object, java.lang.reflect.Method, Object[])}, except for a
     * single method.
     */
    interface MethodHandler {

        Object invoke(Object[] argv) throws Throwable;
    }

    class Default implements InvocationHandlerFactory {

        @Override
        public InvocationHandler create(Target<?> target, Map<Method, InvocationHandlerFactory.MethodHandler> dispatch) {
            return new RedisStreamInvocationHandler(target, dispatch);
        }
    }

}
