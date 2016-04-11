package com.doctor.resteasy.demo01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author sdcuike
 *
 *         Create At 2016年4月11日 下午4:26:10
 */
public class DynamicProxy implements InvocationHandler {

    private Object originalObject;

    private DynamicProxy(Object originalObject) {
        this.originalObject = originalObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println("=== Before executing " + method.getName() + " with arguments " + Arrays.toString(args));

        try {
            result = method.invoke(originalObject, args);
        } finally {
            System.out.println("=== After executing " + method.getName());
        }
        return result;
    }

    public static Object getProxyObject(Object original) {
        return Proxy.newProxyInstance(original.getClass().getClassLoader(), original.getClass().getInterfaces(), new DynamicProxy(original));
    }

}
