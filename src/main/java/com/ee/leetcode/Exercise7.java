package com.ee.leetcode;

/**
 * 二分查找 - 大于给定元素的最小元素
 * @author Administrator
 *
 */
public class Exercise7 {

	public static void main(String[] args) {
		char[] letters = {'z', 'c', 'f', 'j'};
		System.out.println(findMinLetter(letters, 0, letters.length-1));
//		System.out.println(nextGreatestLetter(letters, 'a'));
	}
	
	public static char nextGreatestLetter(char[] letters, char target) {
		int size = letters.length;
		// 找到最小元素位置
		int minIdx = findMinIndex(letters, 0, size-1);
		// 交换位置，形成递增
		for (int i=0, j=minIdx; i<minIdx && j<size; i++, j++) {
			char tmp = letters[i];
			letters[i] = letters[j];
			letters[j] = tmp;
		}
		char letter = findNextLetter(letters, 0, size-1, target);
		if (letter <= target) {
			return letters[0];
		} else {
			return letter;
		}
	}
	
	public static char findNextLetter(char[] letters, int lo, int hi, char target) {
		if (lo == hi) return letters[lo];
		int md = (lo + hi) / 2;
		if (letters[md] > target) return findNextLetter(letters, lo, md, target);
		else return findNextLetter(letters, md+1, hi, target);
	}
	
	public static int findMinIndex(char[] letters, int lo, int hi) {
		if (letters[lo] < letters[hi]) return lo;
		if (lo == hi) return lo;
		int md = (lo + hi) / 2;
		if (letters[lo] > letters[md]) return findMinIndex(letters, lo, md);
		else return findMinIndex(letters, md+1, hi);
	}
	
	public static char findMinLetter(char[] letters, int lo, int hi) {
		if (letters[lo] < letters[hi]) return letters[lo];
		if (lo == hi) return letters[lo];
		int md = (lo + hi) / 2;
		if (letters[lo] > letters[md]) return findMinLetter(letters, lo, md);
		else return findMinLetter(letters, md+1, hi);
	}
}
