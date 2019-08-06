package com.ee.cglib;

import net.sf.cglib.proxy.Enhancer;

public class Executor {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Greet.class);
		enhancer.setCallback(new GreetInterceptor());
		Greet greet = (Greet) enhancer.create();
		greet.sayHello();
		greet.sayGoodbye();
	}
}
