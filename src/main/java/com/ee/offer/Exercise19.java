package com.ee.offer;

/**
 * 连续子数组的最大和
 * @author Administrator
 *
 */
public class Exercise19 {

	public static void main(String[] args) {
		int[] nums = {6, -3, -2, 7, -15, 1, 2, 2};
		System.out.println(findGreatestSumOfSubArray(nums));
	}
	
	public static int findGreatestSumOfSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
	        return 0;
	    int greatestSum = Integer.MIN_VALUE;
	    int sum = 0;
	    for (int val : nums) {
	        sum = sum <= 0 ? val : sum + val;
	        greatestSum = Math.max(greatestSum, sum);
	    }
	    return greatestSum;
	}
}
