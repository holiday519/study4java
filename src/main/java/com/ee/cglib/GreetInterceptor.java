package com.ee.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class GreetInterceptor implements MethodInterceptor {
	
	public void before() {
		System.out.println("do something before invoke..");
	}
	
	public void after() {
		System.out.println("do something after invoke..");
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		if (method.getName().equals("sayHello")) {
			before();
		}
		Object result = proxy.invokeSuper(obj, args);
		if (method.getName().equals("sayHello")) {
			after();
		}
		
		return result;
	}

}
