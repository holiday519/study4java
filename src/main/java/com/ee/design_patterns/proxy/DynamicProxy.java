package com.ee.design_patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
	
	private Object source;
	
	public DynamicProxy(Object source) {
		this.source = source;
	}
	
	public void before() {
		System.out.println("do something before invoke..");
	}
	
	public void after() {
		System.out.println("do something after invoke..");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().equals("sayHello")) {
			before();
		}
		Object result = method.invoke(source, args);
		if (method.getName().equals("sayHello")) {
			after();
		}
		
		return result;
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(getClass().getClassLoader(), source.getClass().getInterfaces(), this);
	}
}
