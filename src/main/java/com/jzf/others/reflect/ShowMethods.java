package com.jzf.others.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ShowMethods {

    public static void main(String[] args) throws Exception {

        Class createClass = CreateClass.class;

        // 获取类的public方法,包括从父类继承的
        // Method[] methods = createClass.getMethods();
        // 获取这个类中声明的方法
        Method[] methods = createClass.getDeclaredMethods();

        Constructor[] constructors = createClass.getConstructors();

        Field[] fields = createClass.getFields();

        for (Method method : methods) {
            print(method);
        }

        print("method end...");

        for (Constructor constructor : constructors) {
            print(constructor);
        }

        print("constructor end...");

        for (Field field : fields) {
            print(field);
        }



    }

    private static void print(Object obj) {
        System.out.println(obj);
    }

}
