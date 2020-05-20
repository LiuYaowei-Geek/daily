package com.lyw.java.javaProxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class SubjectProxy implements MethodInterceptor {

    private Object object;
    public SubjectProxy(Object object) {
        this.object = object;
    }

    //为目标对象生成代理对象
    public Object getProxyInstance() {
        Enhancer en = new Enhancer();
        en.setSuperclass(object.getClass());
        en.setCallback(this);
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object res = method.invoke(object, objects);
        return res;
    }
}
