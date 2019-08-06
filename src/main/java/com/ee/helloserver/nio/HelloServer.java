package com.ee.helloserver.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class HelloServer {

	public static void main(String[] args) {
		int port = 28888;
		
		try {
			Selector selector = Selector.open();
			ServerSocketChannel channel = ServerSocketChannel.open();
			channel.configureBlocking(false);
			channel.bind(new InetSocketAddress(port), 1024);
			channel.register(selector, SelectionKey.OP_ACCEPT);
			
			while (true) {
				selector.select();
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectionKeys.iterator();
				while (it.hasNext()) {
					SelectionKey key = it.next();
					it.remove();
					
					if (key.isValid()) {
						if (key.isAcceptable()) {
							ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
							SocketChannel sc = ssc.accept();
							sc.configureBlocking(false);
							sc.register(selector, SelectionKey.OP_READ);
						}
						
						if (key.isReadable()) {
							new Thread(new Runnable() {
								@Override
								public void run() {
									final SocketChannel sc = (SocketChannel) key.channel();
									ByteBuffer readBuffer = ByteBuffer.allocate(1024);
									try {
										int flag = sc.read(readBuffer);
										if (flag > 0) {
											readBuffer.flip();
											byte[] readBytes = new byte[readBuffer.remaining()];
											readBuffer.get(readBytes);
											String body = (new String(readBytes, "UTF-8")).replace("\n", "");
											String resp = "Hello, " + body + "! ByeBye";
											byte[] writeBytes = resp.getBytes();
											ByteBuffer writeBuffer = ByteBuffer.allocate(writeBytes.length);
											writeBuffer.put(writeBytes);
											writeBuffer.flip();
											sc.write(writeBuffer);
										}
									} catch (IOException e) {
										e.printStackTrace();
									} finally {
										if (sc != null) {
											try {
												sc.close();
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
									}
								}
								
							}).start();
						}
						
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
