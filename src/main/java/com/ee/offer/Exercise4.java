package com.ee.offer;

/**
 * 斐波那契数列
 * @author Administrator
 *
 */
public class Exercise4 {

	public static void main(String[] args) {
		System.out.println(fibonacci(3));
	}
	
	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		int[] pres = new int[2];
		pres[0] = 0;
		pres[1] = 1;
		int fib = 0;
		for (int i=2; i<=n; i++) {
			fib = pres[0] + pres[1];
			pres[0] = pres[1];
			pres[1] = fib;
		}
		
		return fib;
    }
}
