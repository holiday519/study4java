package com.ee.offer;

/**
 * 数值的整数次方
 * @author Administrator
 *
 */
public class Exercise8 {

	public static void main(String[] args) {
		System.out.println(power(1.9, 3));
	}
	
	public static double power(double base, int exponent) {
		if (base == 0 && exponent <= 0) {
			throw new RuntimeException("error");
		}
		
		double res = 1D;
		if (exponent < 0) {
			base = 1 / base;
			exponent = -exponent;
		}
		
		while (exponent > 0) {
			res *= base;
			exponent --;
		}
		
		return res;
	}
}
