package com.ee.leetcode;

/**
 * 有序数组的 Single Element
 * @author Administrator
 *
 */
public class Exercise8 {

	public static void main(String[] args) {
		int[] nums = {3,3,7,7,10,11,11};
		System.out.println(singleNonDuplicate(nums));
	}
	
//	public static int singleNonDuplicate(int[] nums) {
//		int size = nums.length;
//		if (size == 0 || size % 2 == 0) {
//			throw new RuntimeException("error");
//		}
//		return singleNonDuplicate(nums, 0, nums.length-1);
//	}
//	
//	public static int singleNonDuplicate(int[] nums, int lo, int hi) {
//		if (lo == hi) {
//			return nums[lo];
//		}
//		int md = lo + (hi - lo) / 2;
//		if (nums[md] == nums[md-1]) {
//			if ((md - lo) % 2 == 0) {
//				return singleNonDuplicate(nums, lo, md);
//			} else {
//				return singleNonDuplicate(nums, md+1, hi);
//			}
//		} else if (nums[md] == nums[md+1]) {
//			if ((hi - md) % 2 == 0) {
//				return singleNonDuplicate(nums, md, hi);
//			} else {
//				return singleNonDuplicate(nums, lo, md-1);
//			}
//		} else {
//			return nums[md];
//		}
//	}
	
	public static int singleNonDuplicate(int[] nums) {
		int size = nums.length;
		if (size == 0 || size % 2 == 0) {
			throw new RuntimeException("error");
		}
		
		int lo = 0, hi = size - 1;
		while (lo < hi) {
			int md = lo + (hi - lo) / 2;
			if (nums[md] == nums[md-1]) {
				if ((md - lo) % 2 == 0) {
					hi = md;
				} else {
					lo = md + 1;
				}
			} else if (nums[md] == nums[md+1]) {
				if ((hi - md) % 2 == 0) {
					lo = md;
				} else {
					hi = md - 1;
				}
			} else {
				lo = md;
			}
		}
		
		return nums[lo];
	}
}
