package com.ee.offer;

/**
 * 旋转数组的最小数字
 * @author Administrator
 *
 */
public class Exercise3 {

	public static void main(String[] args) {
		int[] nums = {2,1};
		System.out.println(findMin(nums));
	}
	
	public static int findMin(int[] nums) {
		int len = nums.length;
		if (nums[0] < nums[len-1]) {
			return nums[0];
		}
		return findMin(nums, 0, len-1, nums[0]);
	}
	
	public static int findMin(int[] nums, int lo, int hi, int target) {
		if (lo == hi) {
			return nums[lo];
		}
		int md = (lo + hi) / 2;
		if (nums[md] >= target) {
			return findMin(nums, md+1, hi, target);
		} else {
			return findMin(nums, lo, md, target);
		}
	}
}
