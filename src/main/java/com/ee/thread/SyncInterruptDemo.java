package com.ee.thread;

/**
 * 使用synchronized，无法中断等待锁的线程
 * @author Administrator
 *
 */
public class SyncInterruptDemo {

	public void printName(String threadName) {
		synchronized (this) {
			try {
				System.out.println(threadName + " begin");
				Thread.sleep(10000);
				System.out.println(threadName + " end");
			} catch (InterruptedException e) {
				System.out.println(threadName + " interrupt");
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		SyncInterruptDemo d = new SyncInterruptDemo();
		
		Thread t1 = new Thread(() -> d.printName("t1"), "t1");
		Thread t2 = new Thread(() -> d.printName("t2"), "t2");
		
		t1.start();
		Thread.sleep(1000);
		t2.start();
		Thread.sleep(1000);
		t2.interrupt();
	}
}
