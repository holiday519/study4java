package com.ee.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TimeClient {

	public static void main(String[] args) {
		String host = "127.0.0.1";
		int port = 8888;
		
		Socket socket = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		
		try {
			socket = new Socket(host, port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			out.write("TIME");
			out.flush();
			String resp = in.readLine();
			System.out.println("Now is:" + resp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
