package com.ee.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 贪心思想 - 投飞镖刺破气球
 * @author Administrator
 * [[10,16], [2,8], [1,6], [7,12]]
 * 2
 */
public class Exercise4 {

	public static void main(String[] args) {
		List<int[]> points = new ArrayList<int[]>();
		int[] point0 = {10,16};
		int[] point1 = {2,8};
		int[] point2 = {1,6};
		int[] point3 = {7,12};
		points.add(point0);
		points.add(point1);
		points.add(point2);
		points.add(point3);
		System.out.println(findMinArrowShots(points));
	}
	
	public static int findMinArrowShots(List<int[]> balloons) {
		if (balloons == null) {
			return 0;
		}
		Collections.sort(balloons, Comparator.comparingInt(balloon -> balloon[1]));
		int count = 0;
		return shotBalloons(balloons, count);
	}
	
	/**
	 * 射击气球并记录射击次数
	 * @param points
	 * @return
	 */
	public static int shotBalloons(List<int[]> balloons, int count) {
		if (balloons.isEmpty()) {
			return count;
		}
		int point = balloons.get(0)[1];
		List<int[]> restBalloons = new ArrayList<int[]>();
		for (int[] balloon : balloons) {
			if (point < balloon[0] || point > balloon[1]) {
				restBalloons.add(balloon);
			}
		}
		count ++;
		return shotBalloons(restBalloons, count);
	}
}
