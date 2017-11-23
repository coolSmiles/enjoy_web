package com.spring.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClientByTCP {

	//客户端使用的TCP Socket  
    private Socket clientSocket;  
      
    public String toUpperRemote(String serverIp, int serverPort, String str) {  
        StringBuilder recvStrBuilder = new StringBuilder();  
        try {  
            //创建连接服务器的Socket  
            clientSocket = new Socket(serverIp, serverPort);  
              
            //写出请求字符串  
            OutputStream out = clientSocket.getOutputStream();  
            out.write(str.getBytes());  
              
            //读取服务器响应  
            InputStream in = clientSocket.getInputStream();  
            for (int c = in.read(); c != '#'; c = in.read()) {  
                recvStrBuilder.append((char)c);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (clientSocket != null) {  
                    clientSocket.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
          
        return recvStrBuilder.toString();  
    }  
      
    public static void main(String[] args) {  
    	SocketClientByTCP client = new SocketClientByTCP();  
        String recvStr = client.toUpperRemote("127.0.0.1", 10005,"aaaAAAbbbBBBcccCCC#");  
        System.out.println("收到:" + recvStr);  
    }  
}
