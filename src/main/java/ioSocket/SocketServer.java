package ioSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: zhuxun
 * @data: 2019-08-08 14:54
 * @description: 阻塞式，通信
 * 每个请求都需要独立的线程完成数据 Read，业务处理，数据 Write 的完整操作问题。
 * 当并发数较大时，需要创建大量线程来处理连接，系统资源占用较大。
 * 连接建立后，如果当前线程暂时没有数据可读，则线程就阻塞在 Read 操作上，造成线程资源浪费。
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        Socket client = null;
        boolean f = true;
        while(f){
            client = server.accept();
            System.out.println("与客户端连接成功！");
            //为每个客户端连接开启一个线程
            new Thread(new ServerThread(client)).start();
        }
        server.close();
    }
}
