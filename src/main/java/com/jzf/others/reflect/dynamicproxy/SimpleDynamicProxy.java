package com.jzf.others.reflect.dynamicproxy;

import java.lang.reflect.Proxy;

public class SimpleDynamicProxy {

    public static void consume(Interface interf) {
        interf.doSomething();
        interf.doSomethingElse("bonobo");
    }

    public static void main(String[] args) throws Exception {
        RelaObject relaObject = new RelaObject();
        consume(relaObject);

        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
           new Class[] {Interface.class}, new DynamicInvocationHandler(relaObject));
        consume(proxy);

    }

}
