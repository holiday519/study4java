package com.ee.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 填充封闭区域
 * @author Administrator
 *
 */
public class Exercise14 {

	public static void main(String[] args) {
		char[][] board = {{'x','x','x','x'},
				          {'x','o','o','x'},
				          {'x','x','o','x'},
				          {'x','o','x','x'}};
		
		solve(board);
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public static void solve(char[][] board) {
		if (board.length == 0 || board[0].length == 0) {
			return;
		}
		List<Point> points = new ArrayList<Point>();
		int M = board.length;
		int N = board[0].length;
		for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++) {
				if (board[i][j] == 'o') {
					points.addAll(findUnroundPoints(board, i, j, M, N));
				}
			}
		}
		
		for (Point p : points) {
			board[p.i][p.j] = 'o';
		}
	}
	
	private static List<Point> findUnroundPoints(char[][] board, int m, int n, int M, int N) {
		int[][] steps = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
		List<Point> points = new ArrayList<Point>();
		boolean isRounded = true;
		Deque<Point> stack = new ArrayDeque<Point>();
		// 第一个点
		Point point = new Point(m, n);
		stack.addFirst(point);
		points.add(point);
		
		while (!stack.isEmpty()) {
			Point firstPoint = stack.peekFirst();
			if (firstPoint.i == 0 || firstPoint.i == M-1 || firstPoint.j == 0 || firstPoint.j == N-1) isRounded = false;
			Point nextPoint = null;
			for (int[] step : steps) {
				int i = firstPoint.i + step[0];
				int j = firstPoint.j + step[1];
				if (i >= 0 && j >= 0 && i < M && j < N && board[i][j] == 'o') {
					nextPoint = new Point(i, j);
					stack.addFirst(nextPoint);
					points.add(nextPoint);
					board[i][j] = 'x';
					break;
				}
			}
			if (nextPoint == null) {
				stack.pollFirst();
			}
		}
		
		if (isRounded) {
			points.clear();
		}
		
		return points;
	}
	
	private static class Point {
		public int i;
		public int j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
