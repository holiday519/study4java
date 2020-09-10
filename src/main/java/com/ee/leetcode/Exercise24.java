package com.ee.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 括号匹配
 */
public class Exercise24 {


    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }
    
    public static boolean isValid(String s) {
    	Deque<Character> stack = new ArrayDeque<>();
    	Map<Character, Character> map = new HashMap<>();
    	map.put('(', ')');
    	map.put('[', ']');
    	map.put('{', '}');
    	
    	for (int i=0; i<s.length(); i++) {
    		char c = s.charAt(i);
    		if (c == '(' || c == '{' || c == '[') {
    			stack.push(map.get(c));
    		} else {
    			if (stack.isEmpty()) return false;
    			if (stack.pop() != c) return false;
    		}
    	}
    	return stack.isEmpty();
    }
}
