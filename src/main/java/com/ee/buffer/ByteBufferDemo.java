package com.ee.buffer;

import java.nio.ByteBuffer;

public class ByteBufferDemo {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(16);
		buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
		
		buffer.flip();

		System.out.println(buffer.position());
		System.out.println(buffer.limit());

		int count = buffer.remaining();
		byte[] myByteArray = new byte[count];

		for (int i = 0; i < count; i++) {
			myByteArray[i] = buffer.get();
		}

		System.out.println(new String(myByteArray));


	}

}
