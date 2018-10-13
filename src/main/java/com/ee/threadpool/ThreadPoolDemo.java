package com.ee.threadpool;

import java.util.concurrent.*;

public class ThreadPoolDemo {
	
	public static void main(String[] args) {
//		ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
//		Thread task1 = new MyThread("Task-1");
//        Thread task2 = new MyThread("Task-2");
//        pool.scheduleAtFixedRate(task1, 1, 3, TimeUnit.SECONDS);
//        pool.scheduleAtFixedRate(task2, 1, 6, TimeUnit.SECONDS);

		ExecutorService pool = Executors.newSingleThreadExecutor();
		for (int i=0; i<9; i++) {
			Thread task = new MyThread("Task-" + i);
			pool.execute(task);
		}

		System.out.println("pool shutdown");
		pool.shutdownNow();
	}

}

class MyThread extends Thread {
	private String name;
	public MyThread(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ":" + name);
	}
}