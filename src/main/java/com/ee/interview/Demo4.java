package com.ee.interview;

public class Demo4 {
    public static void main(String[] args) {

    }

    /**
     * 右上开始
     * @param target
     * @param matrix
     * @return
     */
    public static boolean rightUp(int target, int[][] matrix) {
        if (matrix == null) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows == 0 || cols == 0) return false;

        int r = 0;
        int c = cols - 1;
        while (r <= rows - 1 && c >= 0) {
            int number = matrix[r][c];
            if (target > number) {
                r ++;
            } else if (target < number) {
                c --;
            } else {
                return true;
            }
        }

        return false;
    }

    public static boolean leftDown(int target, int[][] matrix) {
        if (matrix == null) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows == 0 || cols == 0) return false;

        int r = rows - 1;
        int c = 0;
        while (r >= 0 && c <= cols - 1) {
            int number = matrix[r][c];
            if (target > number) {
                c ++;
            } else if (target < number) {
                r --;
            } else {
                return true;
            }
        }

        return false;
    }
}
