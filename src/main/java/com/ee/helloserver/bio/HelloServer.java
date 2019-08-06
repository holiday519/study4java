package com.ee.helloserver.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {

    public static void main(String[] args) {
        int port = 18888;
        
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                final Socket socket = server.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try (InputStreamReader in = new InputStreamReader(socket.getInputStream());
                        		OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream())) {
                            char[] readChars = new char[32];
                            in.read(readChars);
                            String body = String.valueOf(readChars);
                            System.out.println(body);
                            String resp = "Hello, " + body + "! ByeBye";
                            out.write(resp);
                            out.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
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
        }
    }

}
