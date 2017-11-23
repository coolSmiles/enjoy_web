package com.spring.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SocketServerByTCP_BIO {

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
                final StringBuilder recvStrBuilder = new StringBuilder();  
                
                try {
                	//�пͻ��������������tcp����ʱ��accept�᷵��һ��Socket  
                    //��Socket�Č��˾��ǿͻ��˵�Socket  
                    //������̿��Բ鿴TCP�������ֹ���  
                	final Socket connection = serverSocket.accept();
                	
                	// �����̳߳������߳�
                	Executor executor  = Executors.newFixedThreadPool(100);
                	
                	executor.execute(new Runnable() {

						@Override
						public void run() {
							//ʹ�þֲ����ã���ֹconnection������
							Socket conn = connection;
							
							try {
								InputStream in = conn.getInputStream();  
                                
                                //��ȡ�ͻ��˵������ַ����������ַ�����#�ս�  
                                for (int c = in.read(); c != REQUEST_END_CHAR; c = in.read()) {  
                                    recvStrBuilder.append((char)c);  
                                }  
                                recvStrBuilder.append('#');  
                                  
                                String recvStr = recvStrBuilder.toString();  
                                  
                                //��ͻ���д���������ַ���  
                                OutputStream out = conn.getOutputStream();  
                                out.write(recvStr.toUpperCase().getBytes());
							} catch (Exception e) {
								e.printStackTrace();
							}finally{
								try {  
                                    if (conn != null) {  
                                        conn.close();  
                                    }  
                                } catch (IOException e) {  
                                    e.printStackTrace();  
                                }  
							}
						}  
                	});
                	
				} catch (Exception e) {
					e.printStackTrace();
				}
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
      
    public static void main(String[] args) {  
    	SocketServerByTCP_BIO server = new SocketServerByTCP_BIO();  
        server.startServer(SERVER_IP, SERVER_PORT);  
    }  
}
