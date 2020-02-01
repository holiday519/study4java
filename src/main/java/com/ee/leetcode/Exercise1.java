package com.ee.leetcode;

/**
 * 有序数组的 Two Sum
 * @author Administrator
 *
 */
public class Exercise1 {

	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		int target = 9;
		int[] result = twoSum(numbers, target);
		if (result != null) {
			System.out.println(result[0] + "," + result[1]);
		} else {
			System.out.println("none");
		}
	}
	
	public static int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length < 2) {
			return null;
		}
		
		int lo = 0;
		int hi = numbers.length - 1;
		
		for (;;) {
			int sum = numbers[lo] + numbers[hi];
			if (sum > target) {
				hi --;
			} else if (sum < target) {
				lo ++;
			} else {
				int[] result = new int[2];
				result[0] = numbers[lo];
				result[1] = numbers[hi];
				return result;
			}
			if (lo >= hi) {
				break;
			}
		}
		
		return null;
	}
}
