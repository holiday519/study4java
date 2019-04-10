package com.ee.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockDemo {

	public static void main(String[] args) {
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		
		for (int i=0; i<10; i++) {
			final int num = i;
			new Thread() {

				@Override
				public void run() {
					lock.readLock().lock();
					for (int j=0; j<10; j++) {
						System.out.println("a===" + num);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					lock.readLock().unlock();
				}
				
			}.start();
		}
		for (int i=0; i<10; i++) {
			final int num = i;
			new Thread() {

				@Override
				public void run() {
					lock.writeLock().lock();
					for (int j=0; j<10; j++) {
						System.out.println("b===" + num);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					lock.writeLock().unlock();
				}
				
			}.start();
		}
	}
}
