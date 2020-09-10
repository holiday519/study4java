package com.ee.offer;

/**
 * 二进制中 1 的个数
 * @author Administrator
 *
 */
public class Exercise7 {

	public static void main(String[] args) {
		System.out.println(numberOf1(5));
	}
	
	// 正数
	public static int numberOf1(int n) {
		int count = 0;
		while (n != 0) {
			count ++;
			n = (n-1) & n;
		}
		return count;
	}
}
