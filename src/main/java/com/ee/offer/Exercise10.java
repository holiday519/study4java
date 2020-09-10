package com.ee.offer;

/**
 * 正则表达式匹配
 * @author Administrator
 *
 */
public class Exercise10 {

	public static void main(String[] args) {
		
	}
	
	public static boolean match(char[] str, char[] pattern) {
		int sLen = str.length;
		int pLen = pattern.length;
		int i = 0;
		int j = 0;
		
		while (i < sLen && j < pLen) {
			if (str[i] == pattern[j] || pattern[j] == '.') {
				i ++;
			}
			
			
		}
		
		return false;
	}
}
