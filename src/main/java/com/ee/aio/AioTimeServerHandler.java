package com.ee.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AioTimeServerHandler implements Runnable {
	
	protected CountDownLatch latch;
	protected AsynchronousServerSocketChannel asynchronousServerSocketChannel;
	
	public AioTimeServerHandler(int port) {
		try {
			asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
			asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
			System.out.println("The time server id start in port:" + port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void doAccept() {
		asynchronousServerSocketChannel.<AioTimeServerHandler>accept(this, new AcceptCompletionHandler());
	}

	@Override
	public void run() {
		latch = new CountDownLatch(1);
		doAccept();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
