package com.ee.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * 机器人的运动范围
 * @author Administrator
 *
 */
public class Exercise6 {

	public static void main(String[] args) {
		System.out.println(movingCount(100, 2, 2));
	}
	
	public static int movingCount(int threshold, int rows, int cols) {
		if (threshold < 0 || rows <= 0 || cols <= 0) {
			return 0;
		}
		
		int[] start = {0, 0};
		int[][] nexts = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
		int[][] matrix = new int[rows][cols];
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				matrix[i][j] = 0;
			}
		}
		Deque<int[]> queue = new ArrayDeque<int[]>();
		queue.add(start);
		int count = 1;
		matrix[0][0] = 1;
		while (!queue.isEmpty()) {
			int[] node = queue.removeFirst();
			for (int[] next : nexts) {
				int x = node[0] + next[0];
				int y = node[1] + next[1];
				if (x >= 0 && x < rows && y >= 0 && y < cols && matrix[x][y] == 0 && digitSum(x) + digitSum(y) <= threshold) {
					int[] nextNode = {x, y};
					queue.addLast(nextNode);
					matrix[x][y] = 1;
					count ++;
				}
			}
		}
		
		return count;
	}
	
	public static int digitSum(int num) {
		int sum = 0;
		while (true) {
			sum += num % 10;
			num = num / 10;
			if (num == 0) break; 
		}
		return sum;
	}
	
}
