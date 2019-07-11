package com.ee.z7z8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class StreamReadDemo {

	public static void main(String[] args) throws IOException {
		final PipedInputStream pipedInputStream = new PipedInputStream();
        final PipedOutputStream pipedOutputStream = new PipedOutputStream();
        pipedInputStream.connect(pipedOutputStream);
        
        // 先从pipedInputStream读，看是否阻塞
        new Thread(() -> {
//        	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pipedInputStream));
        	
//        	InputStreamReader inputStreamReader = new InputStreamReader(pipedInputStream);
        	try {
//				System.out.println(bufferedReader.readLine());
        		
//        		char[] chars = new char[64];
//        		inputStreamReader.read(chars);
//        		System.out.println(String.valueOf(chars));
        		
        		byte[] bytes = new byte[64];
        		pipedInputStream.read(bytes);
        		System.out.println(new String(bytes, "UTF-8"));
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
//					bufferedReader.close();
					
//					inputStreamReader.close();
					
					pipedInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
        	
        }).start();
        
        // 等3秒输出内容
        new Thread(() -> {
        	try {
        		System.out.println("waiting...");
        		Thread.sleep(3000);
				pipedOutputStream.write("ningyu".getBytes());
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			} finally {
				try {
					pipedOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
        }).start();
	}

}
