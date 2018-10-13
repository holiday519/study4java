package com.ee.intern;

import java.util.Vector;

public class InternDemo {

	public static void main(String[] args) {
		//
		String s1_1 = new String("test1"); // new在堆中生成一个对象（s1_1），""在常量池中生成一个对象（匿名）
		String s1_2 = s1_1.intern(); // intern返回的是常量池中那个对象（s1_2）
		String s1_3 = "test1"; // 因为在常量池里存在，所以返回的是常量池里的对象（s1_2）
		System.out.println(s1_2 == s1_3); // 都是指向常量池里的对象，true
		//
		String s2_1 = "test2"; // 同上
		String s2_2 = new String("test2");
		String s2_3 = s2_2.intern();
		System.out.println(s2_1 == s2_3); // true
		//
		String s3_2 = new String("test3"); // 同上
		String s3_3 = s3_2.intern(); //
		System.out.println(s3_2 == s3_3); // false
		//
		String s4_1 = new String("test") + new String("4"); // 在堆里生成3个对象（test/4/test4），在常量池里生成2个对象（test/4）
		s4_1.intern(); // 因为在常量池里不存在，所以将堆里test4那个对象的地址拷贝到了常量池里，而s4_1指向了常量池里的那个地址
						// 只用发生拷贝动作，引用才会改变，上面例子中没发生拷贝，所以原有引用不改变，还是指向堆里的
		String s4_2 = "test4"; // 常量池中存在该对象的地址，返回该地址
		System.out.println(s4_1 == s4_2); // true
	}

}
