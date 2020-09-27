package com.xingchen.websocket.demo.socket.client;

import com.xingchen.websocket.demo.socket.ExecutorServicePool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Socket客户端示例
 * @author zhoujian
 */
public class SocketClient {

    /**
     * 服务端套接字IP地址
     */
    private static String HOST = "127.0.0.1";
    /**
     * 服务端套接字监听端口
     */
    private static int PORT = 8088;
    private static Logger logger = LoggerFactory.getLogger(SocketClient.class);

    /**
     * 于主线程中初始化客户端套接字，并完成与服务端套接字的连接
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Socket client = new Socket(HOST, PORT);
        ExecutorServicePool.executorService.execute(new ReceiveThread(client));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        while (true){
            String msg = reader.readLine();
            writer.write(msg);
            writer.write("\n");
            writer.flush();
        }
    }

    /**
     * 用于接收服务端套接字的应答
     */
    static class ReceiveThread implements Runnable{

        private Socket socket;

        public ReceiveThread(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            String receive = null;
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                while ((receive = bufferedReader.readLine()) != null){
                    logger.info("from server: {}", receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
