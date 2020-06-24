package com.ee.leetcode;

/**
 * 第一个错误的版本
 * @author Administrator
 *
 */
public class Exercise9 {

	public static void main(String[] args) {
		boolean[] bools = {false,false,false,false,false,true,true,true,true};
		System.out.println(firstBadVersion(bools));
	}
	
	public static int firstBadVersion(boolean[] bools) {
		int size = bools.length;
		return firstBadVersion(bools, 0, size-1);
	}
	
	public static int firstBadVersion(boolean[] bools, int lo, int hi) {
		if (lo == hi) return lo;
		int md = lo + (hi - lo) / 2;
		boolean bool = bools[md];
		if (bool) {
			return firstBadVersion(bools, lo, md);
		} else {
			return firstBadVersion(bools, md+1, hi);
		}
	}
}
