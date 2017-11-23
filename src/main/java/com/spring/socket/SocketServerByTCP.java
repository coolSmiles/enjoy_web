package com.spring.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketServerByTCP {

	 //������IP  
    public static final String SERVER_IP = "127.0.0.1";  
      
    //�������˿ں�  
    public static final int SERVER_PORT = 10005;  
      
    //�����ս��ַ���  
    public static final char REQUEST_END_CHAR = '#';  
      
    /*** 
     * ���������� 
     * @param �����������Ķ˿ںţ�������ip����ָ����ϵͳ�Զ����� 
     */  
    public void startServer(String serverIP, int serverPort) {  
          
        //������������ַ����  
        InetAddress serverAddr;  
        try {  
            serverAddr = InetAddress.getByName(serverIP);  
        } catch (UnknownHostException e1) {  
            e1.printStackTrace();  
            return;  
        }  
          
        //Java�ṩ��ServerSocket��Ϊ������  
        //����ʹ����Java���Զ��رյ��﷨���ܺ���  
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT, 5, serverAddr)) {  
            while (true) {  
                StringBuilder recvStrBuilder = new StringBuilder();  
                  
                //�пͻ��������������tcp����ʱ��accept�᷵��һ��Socket  
                //��Socket�Č��˾��ǿͻ��˵�Socket  
                //������̿��Բ鿴TCP�������ֹ���  
                try (Socket connection = serverSocket.accept()) {  
                    InputStream in = connection.getInputStream();  
                          
                    //��ȡ�ͻ��˵������ַ����������ַ�����#�ս�  
                    for (int c = in.read(); c != REQUEST_END_CHAR; c = in.read()) {  
                        recvStrBuilder.append((char)c);  
                    }  
                    recvStrBuilder.append('#');  
                      
                    String recvStr = recvStrBuilder.toString();  
                      
                    //��ͻ���д���������ַ���  
                    OutputStream out = connection.getOutputStream();  
                    out.write(recvStr.toUpperCase().getBytes());  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
      
    public static void main(String[] args) {  
    	SocketServerByTCP server = new SocketServerByTCP();  
        server.startServer(SERVER_IP, SERVER_PORT);  
    }  
}
