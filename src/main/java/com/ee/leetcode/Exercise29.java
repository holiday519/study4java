package com.ee.leetcode;

import java.util.LinkedList;

/**
 * 队列实现栈
 * @author Administrator
 *
 */
public class Exercise29 {

	public static void main(String[] args) {
		
	}
	
	private static class Stack {
		private LinkedList<Integer> queue = new LinkedList<>();
		
		public void push(int x) {
			queue.add(x);
			int cnt = queue.size();
			while (cnt-- > 1) {
				queue.add(queue.remove());
			}
		}
		
		public int pop() {
			return queue.remove();
		}
	}
}
