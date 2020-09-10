package com.ee.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 顺时针打印矩阵
 * @author Administrator
 *
 */
public class Exercise17 {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},
						  {5,6,7,8},
						  {9,10,11,12},
						  {13,14,15,16},};
		List<Integer> res = printMatrix(matrix);
		for (int i : res) {
			System.out.println(i);
		}
	}
	
	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int width = matrix[0].length;
		int height = matrix.length;
		
		int[] start = {0, 0};
		int[] diagonal = {width-1, height-1};
		
		while (diagonal[0] - start[0] >= 0 && diagonal[1] - start[1] >= 0) {
			int[] next = new int[2];
			System.arraycopy(start, 0, next, 0, 2);
			while (true) {
				res.add(matrix[next[1]][next[0]]);
				if (next[1] == start[1] && next[0] < diagonal[0]) {
					next[0] ++;
				} else if (next[0] == diagonal[0] && next[1] < diagonal[1]) {
					next[1] ++;
				} else if (next[1] == diagonal[1] && next[0] > start[0]) {
					next[0] --;
				} else if (next[0] == start[0] && next[1] > start[1]) {
					next[1] --;
				}
				
				if (next[0] == start[0] && next[1] == start[1]) break;
			};
			
			start[0] ++;
			start[1] ++;
			diagonal[0] --;
			diagonal[1] --;
		}
		
		return res;
	}
}
