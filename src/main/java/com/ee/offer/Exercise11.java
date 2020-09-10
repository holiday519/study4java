package com.ee.offer;

/**
 * 调整数组顺序使奇数位于偶数前面
 * @author Administrator
 *
 */
public class Exercise11 {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 9};
		reOrderArray(nums);
		for (int num : nums) {
			System.out.println(num);
		}
	}
	
	public static void reOrderArray(int[] nums) {
		int i = 0;
		int len = nums.length;
		int j = len - 1;
		while (true) {
			while (nums[i] % 2 == 1) {
				if (i >= len - 1) break;
				i ++;
			}
			while (nums[j] % 2 == 0) {
				if (j <= 0) break;
				j --;
			}
			if (i >= j) break;
			exch(nums, i, j);
		}
	}
	
	private static void exch(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
