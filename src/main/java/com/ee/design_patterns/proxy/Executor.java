package com.ee.design_patterns.proxy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.ProxyGenerator;

public class Executor {

	public static void main(String[] args) throws IOException {
		GreetInterface proxy = (GreetInterface) (new DynamicProxy(new Greet()).getProxy());
		proxy.sayHello();
		
//		byte[] classFile = ProxyGenerator.generateProxyClass("TestProxy", new Class[]{GreetInterface.class});
//		File file = new File("D:/TestProxy.class");
//		FileOutputStream fos = new FileOutputStream(file);
//		fos.write(classFile);
//		fos.flush();
//		fos.close();
	}

}
