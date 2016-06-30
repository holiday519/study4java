package com.ee.pxene.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {
	
	public static void main(String[] args) {
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
		Thread task1 = new MyThread("Task-1");
        Thread task2 = new MyThread("Task-2");
        pool.scheduleAtFixedRate(task1, 1, 3, TimeUnit.SECONDS);
        pool.scheduleAtFixedRate(task2, 1, 6, TimeUnit.SECONDS);
	}

}

class MyThread extends Thread {
	private String name;
	public MyThread(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ":" + name);
	}
}