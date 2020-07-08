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
		int[][] peoples = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		int[][] sortedPeoples = reconstructQueue(peoples);
		for (int[] people : sortedPeoples) {
			System.out.println(people[0] + "," + people[1]);
		}
	}
	
	public static int[][] reconstructQueue(int[][] peoples) {
		if (peoples == null || peoples.length == 0 || peoples[0].length == 0) {
			return new int[0][0];
		}
		
		Arrays.sort(peoples, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
		int[][] sortedPeoples = new int[peoples.length][2];
		for (int[] people : peoples) {
			int idx = people[1];
			insertPeople(sortedPeoples, idx, people);
		}
		
		return sortedPeoples;
	}
	
	/**
	 * 在idx的位置插入people
	 * @param peoples
	 * @param idx
	 * @param people
	 */
	private static void insertPeople(int[][] peoples, int idx, int[] people) {
		if (peoples[idx] == null) {
			peoples[idx] = people;
		} else {
			for (;idx < peoples.length; idx++) {
				int[] tmpPeople = peoples[idx];
				peoples[idx] = people;
				people = tmpPeople;
			}
		}
	}
}
