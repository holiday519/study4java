package com.ee.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring-test.xml");
		Task task1 = (Task)context.getBean("taskImpl1");
		Task task2 = (Task)context.getBean("taskImpl2");
		
		task1.execute();
		task2.execute();
		System.out.println(Integer.toHexString(15));
	}
}
