package com.ee.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo extends RecursiveTask<Long> {
	
	private long start;
	private long end;
	private static final long CRITICAL = 100000L;
	
	public ForkJoinDemo(long start, long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		long len = end - start;
		if (len < CRITICAL) {
			long sum = 0L;
			for (long i=start; i<=end; i++) {
				sum += i;
			}
			return sum;
		} else {
			long middle = (end + start) / 2;
			ForkJoinDemo left = new ForkJoinDemo(start, middle);
			left.fork();
			ForkJoinDemo right = new ForkJoinDemo(middle+1, end);
			right.fork();
			return left.join() + right.join();
		}
	}
	
	public static void main(String[] args) {
		long l1 = System.currentTimeMillis();
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10000000000L);
		Long invoke = forkJoinPool.invoke(task);
		long l2 = System.currentTimeMillis();
		System.out.println("invoke = " + invoke+"  time: " + (l2-l1));
	}
}
