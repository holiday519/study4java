package com.ee.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<String> {

	private String name;
	
	public CallableDemo(String name) {
		this.name = name;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		CallableDemo c1 = new CallableDemo("ningyu");
		CallableDemo c2 = new CallableDemo("zhanglu");
		FutureTask<String> task1 = new FutureTask<String>(c1);
		FutureTask<String> task2 = new FutureTask<String>(c2);
		executor.submit(task1);
		executor.submit(task2);
		executor.shutdown();
		System.out.println("--------------程序会阻塞到这里--------------");
		System.out.println(task1.get());
		System.out.println(task2.get());
	}

	@Override
	public String call() throws Exception {
		for (int i=0; i<10; i++) {
			System.out.println(name + " is waiting, step is " + i);
			Thread.sleep(1000);
		}
		return name + " has finished, haha";
	}
}
