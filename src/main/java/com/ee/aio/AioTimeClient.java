package com.ee.aio;

public class AioTimeClient {

	public static void main(String[] args) {
		String host = "127.0.0.1";
		int port = 8888;
		new Thread(new AioTimeClientHandler(host, port), "AIO-CLIENT-001").start();
	}

}
