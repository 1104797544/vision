package com.jzf.others.reflect.dynamicproxy;

public class RelaObject implements Interface {

    @Override
    public void doSomething() {
        System.out.println("do something");
    }

    @Override
    public void doSomethingElse(String arg) {
        System.out.println("something else :" + arg);
    }
}
