package com.ee.leetcode;

/**
 * 贪心思想 - 种植花朵
 * @author Administrator
 *
 */
public class Exercise6 {

	public static void main(String[] args) {
		int[] flowerbed = new int[] {1,0,1,0,1};
		int n = 1;
		System.out.println(canPlaceFlowers(flowerbed, n));
	}
	
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int size = flowerbed.length;
		
		for (int i=0; i<size && n>0; i++) {
			if (flowerbed[i] == 0) {
				if (i == 0 && flowerbed[i+1] == 0) {
					n--;
				} else if (i == size-1 && flowerbed[i-1] == 0) {
					n--;
				} else if (flowerbed[i+1] == 0 && flowerbed[i-1] == 0) {
					n--;
				}
			}
		}
		
		return n == 0;
	}
}
