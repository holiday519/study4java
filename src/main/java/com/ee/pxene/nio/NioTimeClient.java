package com.ee.pxene.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioTimeClient {

	public static void main(String[] args) {
		String host = "127.0.0.1";
		int port = 8888;
		boolean stop = false;
		// 调度的线程
		Selector selector = null;
		// 监听客户端连接端口的线程
		SocketChannel channel = null;
		
		try {
			selector = Selector.open();
			channel = SocketChannel.open();
			channel.configureBlocking(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if (channel.connect(new InetSocketAddress(host, port))) {
				channel.register(selector, SelectionKey.OP_READ);
				byte[] req = "TIME".getBytes();
				ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
				writeBuffer.put(req);
				writeBuffer.flip();
				channel.write(writeBuffer);
			} else {
				channel.register(selector, SelectionKey.OP_CONNECT);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while (!stop) {
			try {
				selector.select(1000);
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectionKeys.iterator();
				SelectionKey key = null;
				while (it.hasNext()) {
					key = it.next();
					it.remove();
					
					if (key.isValid()) {
						SocketChannel sc = (SocketChannel) key.channel();
						if (key.isConnectable()) {
							if (sc.finishConnect()) {
								sc.register(selector, SelectionKey.OP_READ);
								byte[] req = "TIME".getBytes();
								ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
								writeBuffer.put(req);
								writeBuffer.flip();
								channel.write(writeBuffer);
							} else {
								// 连接失败
								System.exit(1);
							}
						}
						
						if (key.isReadable()) {
							ByteBuffer readBuffer = ByteBuffer.allocate(1024);
							int flag = sc.read(readBuffer);
							if (flag > 0) {
								readBuffer.flip();
								byte[] readBytes = new byte[readBuffer.remaining()];
								readBuffer.get(readBytes);
								String body = new String(readBytes, "UTF-8");
								System.out.println("Now is " + body);
								stop = true;
							} else if (flag < 0) {
								key.cancel();
								sc.close();
							} else {
								// 读到0，什么也不做
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
