package com.ee.offer;

/**
 * 礼物的最大价值
 * @author Administrator
 *
 */
public class Exercise20 {

	public static void main(String[] args) {
		int[][] values = {{1,10,3,8},
						  {12,2,9,6},
						  {5,7,4,11},
						  {3,7,16,5}};
		System.out.println(getMost(values));
	}
	
	public static int getMost(int[][] values) {
		int rows = values.length;
		int cols = values[0].length;
		if (values == null || rows <= 0 || cols <= 0) {
			return 0;
		}
		
		int[][] maxValues = new int[rows][cols];
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				int left = 0;
				int up = 0;
				if (i > 0) up = maxValues[i-1][j];
				if (j > 0) left = maxValues[i][j-1];
				
				maxValues[i][j] = Math.max(up, left) + values[i][j];
			}
		}
		
		return maxValues[rows-1][cols-1];
	}
}
