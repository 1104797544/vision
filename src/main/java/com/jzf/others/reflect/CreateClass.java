package com.jzf.others.reflect;

public class CreateClass {

    private Class<?> getClass(String className) throws Exception {
        return Class.forName(className);
    }

    private Class<?> getClass(Object obj) {
        return obj.getClass();
    }

    /**
     * 根据类字面量常量来创建class对象
     * 这种方式不会触发类的初始化
     * @return
     * @throws Exception
     */
    private Class<?> getClassWithAttr() {
        return boolean.class;
    }

    public static void main(String[] args) throws Exception {
        // 泛化的class引用
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;
        genericIntClass = Integer.TYPE;

        // 普通class对象引用可以被指向为任何其他的class对象
        intClass = double.class;
        // 泛型class对象引用只能被赋值为其执行的class对象引用
        //genericIntClass = double.class;

        // 这里的class对象使用了确切类型,只接受Number的class对象，所以Integer虽然继承自Number,但是这种赋值方式是错误的
        //Class<Number> genericNumberClass = int.class;
        // 当使用通配符时,class对象引用可以接受继承自Number类的所有类的class对象
        Class<? extends Number> genericNumberClass = int.class;
        genericNumberClass = double.class;

        Class<TestClass> test = (Class<TestClass>) Class.forName("com.jzf.others.reflect.TestClass");
        // 使用newInstance方法创建类的对象,类必须有默认的构造器方法(无参构造器)
        TestClass testClass = test.newInstance();


        // 新的转型语法 java5
        SuperTestClass superTestClass = new TestClass();
        Class<TestClass> testClassClass = TestClass.class;
        TestClass testClass1 = testClassClass.cast(superTestClass);
    }

}
