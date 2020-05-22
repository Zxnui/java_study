package ioSocket;

import java.io.*;
import java.net.Socket;

public class ClientTest {
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                try {
                    Socket socket = new Socket("192.168.1.238",9999);

                    PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

                    while (true) {
                        printWriter.println("test" + Thread.currentThread().getName());
                        printWriter.write("test" + Thread.currentThread().getName());
                        printWriter.flush();

                        InputStream in = socket.getInputStream();
                        byte b[] = new byte[1024];
                        in.read(b);

                        System.out.println(new String(b));
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
