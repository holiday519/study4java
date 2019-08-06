package com.ee.buffer;

import java.nio.ByteBuffer;

public class ByteBufferDemo {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
		
		buffer.flip();
		buffer.position(2).limit(4);
		buffer.compact();
		System.out.println();
//		for (int i = 0; buffer.hasRemaining(); i++) {
//			System.out.println(buffer.get());
//		}
	}

}
