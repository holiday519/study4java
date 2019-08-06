package com.ee.aio;

public class AioTimeServer {

	public static void main(String[] args) {
		int port = 8888;
		AioTimeServerHandler timeServer = new AioTimeServerHandler(port);
		new Thread(timeServer, "AIO-SERVER-001").start();
	}
}
