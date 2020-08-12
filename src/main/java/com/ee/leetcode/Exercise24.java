package com.ee.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Exercise23
 */
public class Exercise24 {


    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        List<Character> lefts = new ArrayList<>();
        lefts.add('(');
        lefts.add('[');
        lefts.add('{');

        List<Character> rights = new ArrayList<>();
        rights.add(')');
        rights.add(']');
        rights.add('}');

        List<String> pairs = new ArrayList<>();
        pairs.add("()");
        pairs.add("[]");
        pairs.add("{}");

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (lefts.contains(c)) {
                stack.addFirst(c);

            } else if (rights.contains(c)) {
                if (stack.isEmpty()) return false;
                char[] cs = {stack.pop(), c};
                String pair = String.valueOf(cs);
                if (!pairs.contains(pair)) return false;
            }
        }

        return stack.isEmpty();
    }
}
