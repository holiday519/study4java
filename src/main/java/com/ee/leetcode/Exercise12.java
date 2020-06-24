package com.ee.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 组成整数的最小平方数数量
 * @author Administrator
 *
 */
public class Exercise12 {

	public static void main(String[] args) {
		System.out.println(numSquares(13));
	}
	
	public static int numSquares(int n) {
		if (n <= 0) {
			throw new RuntimeException("error");
		}
		Deque<Integer> queue = new ArrayDeque<Integer>();
		
		queue.addLast(0);
		int count = 1;
		int step = 0;
		
		loop1: while (true) {
			step ++;
			int tmpCount = count;
			for (int i=0; i<count; i++) {
				int m = queue.pollFirst();
				tmpCount --;
				int l = 0;
				loop2: while (true) {
					l ++;
					int k = m+l*l;
					if (k < n) {
						queue.addLast(k);
						tmpCount ++;
					} else if (k > n) {
						break loop2;
					} else {
						break loop1;
					}
				}
			}
			count = tmpCount;
		}
		return step;
	}
}
