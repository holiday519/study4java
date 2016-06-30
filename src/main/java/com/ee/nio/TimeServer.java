package com.ee.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TimeServer {
	
	public static void main(String[] args) {
		int port = 8888;
		
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(port);
			while (true) {
				final Socket socket = server.accept();
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						BufferedReader in = null;
						BufferedWriter out = null;
						
						try {
							in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
							out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
							String body = in.readLine();
							String currentTime = "TIME".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
							out.write(currentTime);
							out.flush();
						} catch (IOException e) {
							e.printStackTrace();
						} finally {
							if (in != null) {
								try {
									in.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							if (out != null) {
								try {
									out.close();
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
					
				}).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
