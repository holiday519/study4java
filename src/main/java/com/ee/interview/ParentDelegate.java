package com.ee.interview;

import java.io.IOException;
import java.io.InputStream;

public class ParentDelegate {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ClassLoader classLoader = new ClassLoader() {

			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
				InputStream stream = getClass().getResourceAsStream(fileName);
				if (stream != null) {
					try {
						byte[] b = new byte[stream.available()];
						stream.read(b);
						return defineClass(name, b, 0, b.length);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				return super.loadClass(name);
			}
		};
		
		Object obj = classLoader.loadClass("com.ee.interview.ParentDelegate").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof ParentDelegate);
	}
}
