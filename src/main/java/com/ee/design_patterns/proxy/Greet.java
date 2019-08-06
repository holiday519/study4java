package com.ee.design_patterns.proxy;

public class Greet implements GreetInterface {

	@Override
	public void sayHello() {
		System.out.println("Hello");
	}

	@Override
	public void sayGoodbye() {
		System.out.println("goodbye");
	}
 
}
