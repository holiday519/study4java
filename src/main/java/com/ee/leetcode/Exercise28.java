package com.ee.leetcode;

import java.util.Stack;

/**
 * 栈实现队列
 * @author Administrator
 *
 */
public class Exercise28 {

	public static void main(String[] args) {
		
	}
	
	private static class Queue {
		private Stack<Integer> in = new Stack<Integer>();
		private Stack<Integer> out = new Stack<Integer>();
		
		public void add(int x) {
			in.push(x);
		}
		
		public int remove() {
			if (out.isEmpty()) {
				while (!in.isEmpty()) {
					out.push(in.pop());
				}
			}
			return out.pop();
		}
	}
	
}
