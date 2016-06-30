package com.ee.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class NioTimeServer {
	
	public static void main(String[] args) {
		int port = 8888;
		
		// 调度的线程
		Selector selector = null;
		// 监听客户端连接端口的线程
		ServerSocketChannel channel = null;
		
		try {
			selector = Selector.open();
			channel = ServerSocketChannel.open();
			channel.configureBlocking(false);
			// 1024是端口的最大连接数
			channel.bind(new InetSocketAddress(port), 1024);
			// selector会监听channel上所有连接的状态是否是OP_ACCEPT
			channel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while (true) {
			try {
				// 1s的超时时间
				selector.select(1000);
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectionKeys.iterator();
				SelectionKey key = null;
				while (it.hasNext()) {
					key = it.next();
					it.remove();
					// 处理数据
					if (key.isValid()) {
						if (key.isAcceptable()) {
							ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
							SocketChannel sc = ssc.accept();
							sc.configureBlocking(false);
							sc.register(selector, SelectionKey.OP_READ);
						}
						if (key.isReadable()) {
							SocketChannel sc = (SocketChannel) key.channel();
							// buffer容量为1k
							ByteBuffer readBuffer = ByteBuffer.allocate(1024);
							int flag = sc.read(readBuffer);
							if (flag > 0) {
								// 读取/写入channel前调用flip方法， 设置limit和position
								readBuffer.flip();
								byte[] readBytes = new byte[readBuffer.remaining()];
								readBuffer.get(readBytes);
								String body = new String(readBytes, "UTF-8");
								String currentTime = "TIME".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
								// 写返回值
								if(currentTime != null && currentTime.length() > 0) {
									byte[] writeBytes = currentTime.getBytes();
									ByteBuffer writeBuffer = ByteBuffer.allocate(writeBytes.length);
									writeBuffer.put(writeBytes);
									writeBuffer.flip();
									sc.write(writeBuffer);
								}
							}
							// 回收资源
							sc.close();
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
