package com.ee.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给表达式加括号
 * @author Administrator
 *
 */
public class Exercise10 {

	public static void main(String[] args) {
		
	}
	
	public static List<Integer> diffWaysToCompute(String input) {
	    List<Integer> ways = new ArrayList<>();
	    for (int i = 0; i < input.length(); i++) {
	        char c = input.charAt(i);
	        if (c == '+' || c == '-' || c == '*') {
	            List<Integer> left = diffWaysToCompute(input.substring(0, i));
	            List<Integer> right = diffWaysToCompute(input.substring(i + 1));
	            for (int l : left) {
	                for (int r : right) {
	                    switch (c) {
	                        case '+':
	                            ways.add(l + r);
	                            break;
	                        case '-':
	                            ways.add(l - r);
	                            break;
	                        case '*':
	                            ways.add(l * r);
	                            break;
	                    }
	                }
	            }
	        }
	    }
	    if (ways.size() == 0) {
	        ways.add(Integer.valueOf(input));
	    }
	    return ways;
	}
	
}
