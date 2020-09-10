package com.ee.thread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class SyncDemo {
	
	private final OneShotLatch latch = new OneShotLatch();
	
	public void printName(String threadName) {
		System.out.println(latch.getState());
		try {
			latch.await();
			System.out.println(threadName + " running");
		} catch (InterruptedException e) {
			System.out.println(threadName + " interrupt");
		}
	}
	
	public void signal() {
		latch.signal();
	}
	
	public static void main(String[] args) throws InterruptedException {
		SyncDemo d = new SyncDemo();
		Thread t1 = new Thread(() -> d.printName("t1"), "t1");
		Thread t2 = new Thread(() -> d.printName("t2"), "t2");
		t1.start();
		t2.start();
		
		Thread.sleep(10000);
		d.signal();
	}
	
	private class OneShotLatch {
		
		private final Sync sync = new Sync();
		
		public int getState() {
			return sync.getSuperState();
		}
		
		public void signal() {
			sync.releaseShared(0);
		}
		
		public void await() throws InterruptedException {
			sync.acquireSharedInterruptibly(0);
		}
		
		private class Sync extends AbstractQueuedSynchronizer {

			public int getSuperState() {
				return getState();
			}
			
			@Override
			protected int tryAcquireShared(int arg) {
				return getState() == 1 ? 1 : -1;
			}

			@Override
			protected boolean tryReleaseShared(int arg) {
				setState(1);
				return true;
			}
			
		}
	}
	
}
