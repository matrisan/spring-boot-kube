package com.matrixboot.spring.boot.kube.infrastructure.annotation;




import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

import static feign.Util.checkNotNull;

/**
 * <p>
 * create in 2021/12/15 12:16 AM
 *
 * @author shishaodong
 * @version 0.0.1
 */
public class RedisStreamInvocationHandler implements InvocationHandler {

    private final Target target;

    private final Map<Method, InvocationHandlerFactory.MethodHandler> dispatch;

    RedisStreamInvocationHandler(Target target, Map<Method, InvocationHandlerFactory.MethodHandler> dispatch) {
        this.target = checkNotNull(target, "target");
        this.dispatch = checkNotNull(dispatch, "dispatch for %s", target);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        switch (method.getName()) {
            case "equals":
                try {
                    Object otherHandler = args.length > 0 && args[0] != null ? Proxy.getInvocationHandler(args[0]) : null;
                    return equals(otherHandler);
                } catch (IllegalArgumentException e) {
                    return false;
                }
            case "hashCode":
                return hashCode();
            case "toString":
                return toString();
            default:
                return dispatch.get(method).invoke(args);
        }
    }
}