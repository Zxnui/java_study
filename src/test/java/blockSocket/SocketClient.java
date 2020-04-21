package blockSocket;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class SocketClient {

    public static void send(String server, int port){
        try {
            Socket socket = new Socket(server, port);
            socket.setSoTimeout(100000);

            System.out.println("正在连接服务器");

            //从控制台读入数据
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            //获取Socket的输出流，用来发送数据到服务端
            PrintStream out = new PrintStream(socket.getOutputStream());
            //获取Socket的输入流，用来接收从服务端发送过来的数据
            BufferedReader buf =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
            boolean running = true;
            while(running){
                System.out.print("输入信息：");
                String str = input.readLine();
                out.println(str);

                if("bye".equals(str)){
                    running = false;
                }else{
                    try{
                        //从服务器端接收数据有个时间限制（系统自设，也可以自己设置），超过了这个时间，便会抛出该异常
                        String echo = buf.readLine();
                        System.out.println("收到消息：" + echo);
                    }catch(SocketTimeoutException e){
                        System.out.println("Time out, No response");
                    }
                }
            }

            input.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static void main(String[] args){
        send("127.0.0.1", 9999);
    }
}