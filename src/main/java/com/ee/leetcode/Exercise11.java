package com.ee.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 计算在网格中从原点到特定点的最短路径长度
 * @author Administrator
 *
 */
public class Exercise11 {

	public static void main(String[] args) {
//		int[][] matrix = {{0,0,0,1,0,0,0,1,0,0,0},
//						  {1,1,0,1,0,1,0,1,0,1,0},
//						  {1,1,0,0,0,1,0,0,0,1,0},
//						  {1,1,1,1,1,1,1,1,1,1,0},
//						  {1,1,1,1,1,1,1,1,1,1,0},
//						  {1,1,1,1,1,1,1,1,1,1,0},
//						  {1,1,1,1,1,1,1,1,1,1,0},
//						  {1,1,1,1,1,1,1,1,1,1,0},
//						  {1,1,1,1,1,1,1,1,1,1,0},
//						  {1,1,1,1,1,1,1,1,1,1,0},
//						  {1,1,1,1,1,1,1,1,1,1,0}};
		
//		int[][] matrix = {{0,0,0,1,0,0,0,1,0,0,0},
//						  {1,0,0,1,0,1,0,1,0,1,0},
//						  {1,1,0,0,0,1,0,0,0,1,0},
//						  {1,1,1,0,1,1,1,1,1,1,0},
//						  {1,1,1,1,0,1,1,1,1,1,0},
//						  {1,1,1,1,1,0,1,1,1,1,0},
//						  {1,1,1,1,1,1,0,1,1,1,0},
//						  {1,1,1,1,1,1,1,0,1,1,0},
//						  {1,1,1,1,1,1,1,1,0,1,0},
//						  {1,1,1,1,1,1,1,1,1,0,0},
//						  {1,1,1,1,1,1,1,1,1,1,0}};
		int[][] matrix = {{0}};
		
		System.out.println(shortestPathBinaryMatrix(matrix));
	}
	
	public static int shortestPathBinaryMatrix(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0 || grid.length != grid[0].length) {
			return -1;
		}
		
		int N = grid.length;
		
		if (grid[0][0] != 0 || grid[N-1][N-1] != 0) {
			return -1;
		}
		
		Deque<Point> queue = new ArrayDeque<Point>();
		queue.addLast(new Point(0, 0, 1));
		Point findPoint = null;
		
		while (!queue.isEmpty()) {
			Point point = queue.pollFirst();
			if (point.i == N-1 && point.j == N-1) {
				findPoint = point;
				break;
			}
			
			List<Point> aroundPoints = getAroundPoints(point, 0, N-1);
			for (Point aroundPoint : aroundPoints) {
				int i = aroundPoint.i;
				int j = aroundPoint.j;
				if (grid[i][j] == 0) {
					queue.addLast(aroundPoint);
				}
				// 遍历过的为-1
				grid[i][j] = -1;
			}
		}
		
		return findPoint == null ? -1 : findPoint.level;
	}
	
	public static List<Point> getAroundPoints(Point point, int min, int max) {
		List<Point> points = new ArrayList<Point>();
		int i = point.i; // 行
		int j = point.j; // 列
		int[][] steps = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
		for (int[] step : steps) {
			int ii = i + step[0];
			int jj = j + step[1];
			if (ii >= min && ii <= max && jj >= min && jj <= max) {
				points.add(new Point(ii, jj, point.level + 1));
			}
		}
		return points;
	}
	
	public static class Point {
		public int i;
		public int j;
		public int level;
		public Point(int i, int j, int level) {
			this.i = i;
			this.j = j;
			this.level = level;
		}
	}
}
