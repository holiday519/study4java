package com.ee.hadoop;

import java.io.UnsupportedEncodingException;

import org.apache.hadoop.io.Text;

public class StringAndText {

	public static void main(String[] args) throws UnsupportedEncodingException {
//		String s = "big";
//		System.out.println("String:" + s);
//		System.out.println(s.length());
//		System.out.println(s.getBytes("UTF-8").length);
//		System.out.println(s.indexOf("b"));
//		System.out.println(s.indexOf("i"));
//		System.out.println(s.indexOf("g"));
//		System.out.println(s.charAt(0));
//		System.out.println(s.charAt(1));
//		System.out.println(s.charAt(2));
//
//		Text t = new Text("big");
//		System.out.println("Text:" + t);
//		System.out.println(t.getLength());
//		System.out.println(t.find("b"));
//		System.out.println(t.find("i"));
//		System.out.println(t.find("g"));
//		System.out.println(t.charAt(0));
//		System.out.println((int) 'b');
		
//		String s = "\u0045\u00fd\u00DF";
//		System.out.println("String:" + s);
//		System.out.println(s.length());
//		System.out.println(s.getBytes("UTF-8").length);
//		System.out.println(s.indexOf("\u0045"));
//		System.out.println(s.indexOf("\u00fd"));
//		System.out.println(s.indexOf("\u00DF"));
//		System.out.println(s.charAt(0));
//		System.out.println(s.charAt(1));
//		System.out.println(s.charAt(2));
//
//		Text t = new Text("\u0045\u00fd\u00DF");
//		System.out.println("Text:" + t);
//		System.out.println(t.getLength());
//		System.out.println(t.find("\u0045"));
//		System.out.println(t.find("\u00fd"));
//		System.out.println(t.find("\u00DF"));
//		System.out.println(t.charAt(0));
//		System.out.println((int) '\u0045');
		
		String s = "我是谁";
		System.out.println("String:" + s);
		System.out.println(s.length());
		System.out.println(s.getBytes("UTF-8").length);
		System.out.println(s.indexOf("我"));
		System.out.println(s.indexOf("是"));
		System.out.println(s.indexOf("谁"));
		System.out.println(s.charAt(0));
		System.out.println(s.charAt(1));
		System.out.println(s.charAt(2));

		Text t = new Text("我是谁");
		System.out.println("Text:" + t);
		System.out.println(t.getLength());
		System.out.println(t.find("我"));
		System.out.println(t.find("是"));
		System.out.println(t.find("谁"));
		System.out.println(t.charAt(0));
		System.out.println((int) '我');
	}

}
