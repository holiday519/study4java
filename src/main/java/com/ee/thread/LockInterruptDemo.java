package com.ee.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock，可以中断等待锁的线程
 * @author Administrator
 *
 */
public class LockInterruptDemo {
	
	private Lock lock = new ReentrantLock();

	public void printName(String threadName) {
		try {
			lock.lockInterruptibly();
			System.out.println(threadName + " begin");
			Thread.sleep(10000);
			System.out.println(threadName + " end");
		} catch (InterruptedException e) {
			System.out.println(threadName + " interrupt");
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		LockInterruptDemo d = new LockInterruptDemo();
		
		Thread t1 = new Thread(() -> d.printName("t1"), "t1");
		Thread t2 = new Thread(() -> d.printName("t2"), "t2");
		
		t1.start();
		Thread.sleep(1000);
		t2.start();
		Thread.sleep(1000);
		t2.interrupt();
	}
}
