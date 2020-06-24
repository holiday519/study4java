package com.ee.leetcode;

import java.util.Arrays;

/**
 * 贪心思想 - 根据身高和序号重组队列
 * @author Administrator
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class Exercise5 {

	public static void main(String[] args) {
		
	}
	
	public static int[][] reconstructQueue(int[][] people) {
		if (people == null || people.length == 0 || people[0].length == 0) {
			return new int[0][0];
		}
		
		Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
		
		return null;
	}
	
}
