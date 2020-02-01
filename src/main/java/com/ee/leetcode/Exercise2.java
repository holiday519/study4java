package com.ee.leetcode;

/**
 * 两数平方和
 * @author Administrator
 *
 */
public class Exercise2 {

	public static void main(String[] args) {
		System.out.println(judgeSquareSum(5));
	}
	
	public static boolean judgeSquareSum(int target) {
		if (target <= 0) {
			return false;
		}
		
		int min = 0;
		int max = (int) Math.sqrt(target);
		
		for (;;) {
			int sum = min*min + max*max;
			if (sum > target) {
				max --;
			} else if (sum < target) {
				min ++;
			} else {
				return true;
			}
			
			if (min >= max) {
				break;
			}
		}
		
		return false;
	}
}
