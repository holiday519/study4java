package com.ee.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 栈的压入、弹出序列
 * @author Administrator
 *
 */
public class Exercise18 {

	public static void main(String[] args) {
		int[] pushSequence = {1,2,3,4,5};
		int[] popSequence = {4,3,5,1,2};
		System.out.println(isPopOrder(pushSequence, popSequence));
	}
	
	public static boolean isPopOrder(int[] pushSequence, int[] popSequence) {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		int len = pushSequence.length;
		int j = 0;
		for (int i=0; i<len; i++) {
			if (pushSequence[i] == popSequence[j]) {
				j ++;
				while (!stack.isEmpty() && stack.getFirst() == popSequence[j]) {
					stack.removeFirst();
					j ++;
				}
			} else {
				stack.addFirst(pushSequence[i]);
			}
		}
		return j == len;
	}
}
