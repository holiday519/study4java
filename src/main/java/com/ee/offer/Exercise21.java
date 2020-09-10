package com.ee.offer;

public class Exercise21 {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 3, 3, 3, 4, 6, 100, 100, 100, 100, 100, 1000, 10000};
		int K = 1000;
		System.out.println(getNumberOfK(nums, K));
	}
	
	public static int getNumberOfK(int[] nums, int K) {
	    int first = binarySearch(nums, K);
	    int last = binarySearch(nums, K + 1);
	    return (first == nums.length || nums[first] != K) ? 0 : last - first;
	}
	
	private static int binarySearch(int[] nums, int K) {
		int l = 0, h = nums.length;
	    while (l < h) {
	        int m = l + (h - l) / 2;
	        if (nums[m] >= K)
	            h = m;
	        else
	            l = m + 1;
	    }
	    return l;
	}
}
