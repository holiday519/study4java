package com.ee.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 * @author Administrator
 *
 */
public class Exercise30 {

	public static void main(String[] args) {
//		String s = "abc";
//		String[] ss = cutString(s, 0);
//		
//		System.out.println(ss[0]);
//		System.out.println(ss[1]);
		
		String s = "1231231231234";
		List<String> res = restoreIpAddresses(s);
		for (String e : res) {
			System.out.println(e);
		}
	}
	
	public static List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		
		int len1 = s.length();
		for (int i = 1; i <= len1-1; i++) {
			String[] ip = new String[4];
			String[] ss1 = cutString(s, i);
			if (isInvalid(ss1[0])) break;
			ip[0] = ss1[0];
			
			int len2 = ss1[1].length();
			for (int j = 1; j <= len2-1; j++) {
				String[] ss2 = cutString(ss1[1], j);
				if (isInvalid(ss2[0])) break;
				ip[1] = ss2[0];
				
				int len3 = ss2[1].length();
				for (int k = 1; k <= len3-1; k++) {
					String[] ss3 = cutString(ss2[1], k);
					if (isInvalid(ss3[0]) || isInvalid(ss3[1])) continue;
					ip[2] = ss3[0];
					ip[3] = ss3[1];
					res.add(ip[0] + "." + ip[1] + "." + ip[2] + "." + ip[3]);
				}
			}
		}
		
		return res;
    }
	
	private static boolean isInvalid(String s) {
		if (s.matches("[0-9]{1,3}")) {
			if (s.startsWith("0") && s.length() > 1) {
				return true;
			}
			int i = Integer.parseInt(s);
			if (i > 255) {
				return true;
			}
			return false;
		}
		
		return true;
	}
	
	private static String[] cutString(String s, int pos) {
		String[] ss = new String[2];
		ss[0] = s.substring(0, pos);
		ss[1] = s.substring(pos, s.length());
		return ss;
	}
}
