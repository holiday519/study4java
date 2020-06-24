package com.ee.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 双指针 - 最长子序列
 * @author Administrator
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * apple
 */
public class Exercise3 {

	public static String findLongestWord(String s, List<String> d) {
		List<String> orderD = d.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
		for (String tar : orderD) {
			if (isSubstr(s, tar)) {
				return tar;
			}
		}
		return null;
	}
	
	private static boolean isSubstr(String s, String tar) {
		int sLen = s.length();
		int tarLen = tar.length();
		int i=0, j=0;
		while (i < sLen && j < tarLen) {
			if (s.charAt(i) == tar.charAt(j)) {
				j ++;
			}
			i ++;
		}
		return j == tarLen;
	}
	
	public static void main(String[] args) {
		String s = "abpcplea";
		List<String> d = new ArrayList<String>() {{
			add("ale");
			add("apple");
			add("monkey");
			add("plea");
		}};
		
		System.out.println(findLongestWord(s, d));
	}
}
