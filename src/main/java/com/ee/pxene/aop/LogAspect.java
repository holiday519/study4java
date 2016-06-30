package com.ee.pxene.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	@Pointcut("execution(* com.ee.test.aop.Task.execute(..))")
	public void taskExecute() {
		
	}
	@Before("taskExecute()")
	public void taskBefore(JoinPoint point) {
		System.out.println("log before task" + point.getTarget());
	}
	@AfterReturning("taskExecute()")
	public void taskAfter() {
		System.out.println("log after task");
	}
	@AfterThrowing("taskExecute()")
	public void taskException() {
		System.out.println("log exception task");
	}
}
