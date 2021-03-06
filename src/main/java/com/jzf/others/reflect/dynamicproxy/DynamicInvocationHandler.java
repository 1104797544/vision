package com.jzf.others.reflect.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicInvocationHandler implements InvocationHandler {

    private Object proxied;

    public DynamicInvocationHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("...proxy... class:" + proxy.getClass() + " method: " + method + " args: " + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println(arg);
            }
        }
        return method.invoke(proxied, args);
    }
}
