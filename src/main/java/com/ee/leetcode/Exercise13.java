package com.ee.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 查找最大的连通面积
 * @author Administrator
 *
 */
public class Exercise13 {

	public static void main(String[] args) {
		int[][] matrix = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
						  {0,0,0,0,0,0,0,1,1,1,0,0,0},
						  {0,1,1,0,1,0,0,0,0,0,0,0,0},
						  {0,1,0,0,1,1,0,0,1,0,1,0,0},
						  {0,1,0,0,1,1,0,0,1,1,1,0,0},
						  {0,0,0,0,0,0,0,0,0,0,1,0,0},
						  {0,0,0,0,0,0,0,1,1,1,0,0,0},
						  {0,0,0,0,0,0,0,1,1,0,0,0,0}};
		
		System.out.println(maxAreaOfIsland(matrix));
	}
	
	public static int maxAreaOfIsland(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int M = grid.length;
		int N = grid[0].length;
		int maxArea = 0;
		
		for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++) {
				if (grid[i][j] == 1) {
					int area = getIslandArea(grid, i, j, M, N);
					maxArea = area > maxArea ? area : maxArea;
				}
			}
		}
		
		return maxArea;
	}
	
	public static int getIslandArea(int[][] grid, int m, int n, int M, int N) {
		int area = 0;
		int[][] steps = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
		Deque<Point> stack = new ArrayDeque<Point>();
		// 第一个点
		Point point = new Point(m, n);
		stack.addFirst(point);
		area++;
		grid[m][n] = 0;
		while (!stack.isEmpty()) {
			Point firstPoint = stack.peekFirst();
			Point nextPoint = null;
			for (int[] step : steps) {
				int i = firstPoint.i + step[0];
				int j = firstPoint.j + step[1];
				if (i >= 0 && j >= 0 && i < M && j < N && grid[i][j] == 1) {
					nextPoint = new Point(i, j);
					stack.addFirst(nextPoint);
					area++;
					grid[i][j] = 0;
					break;
				}
			}
			if (nextPoint == null) {
				stack.pollFirst();
			}
		}
		
		return area;
	}
	
	public static class Point {
		public int i;
		public int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
