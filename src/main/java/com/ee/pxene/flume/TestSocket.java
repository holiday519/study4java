package com.ee.pxene.flume;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestSocket {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String host = "172.16.15.129";
		int port = 44444;
		
		Socket client = new Socket(host, port);
		Writer writer = new OutputStreamWriter(client.getOutputStream());
		writer.write("Hello World");
		writer.flush();
		writer.close();
		client.close();
		System.out.println("finish");
	}
	
}
