package com.spring.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CopyOfSocketServerByTCP_NIO {

	//������IP  
    public static final String SERVER_IP = "127.0.0.1";  
      
    //�������˿ں�  
    public static final int SERVER_PORT = 10005;  
      
    //�����ս��ַ���  
    public static final char REQUEST_END_CHAR = '#';  
      
    /*** 
     * ���������� 
     * @param �����������Ķ˿ںţ�������ip����ָ����ϵͳ�Զ����� 
     * @throws Exception 
     */  
    public void startServer(String serverIP, int serverPort) throws Exception {  
        
    	//ʹ��NIO��Ҫ�õ�ServerSocketChannel  
        //���а���һ��ServerSocket����
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        
        //������ַ����  
        InetSocketAddress localAddr = new InetSocketAddress(serverIP, serverPort);
        
        //�������󶨵�ַ  
        serverChannel.bind(localAddr);  
          
        //����Ϊ������  
        serverChannel.configureBlocking(false);  
          
        //ע�ᵽselector�������ServerSocket��accept  
        //������selector����accept�ܷ񷵻�  
        //������accept���Է���ʱ����õ�֪ͨ  
        //ע�⣬�ǿ��Է��أ�����Ҫ����accept  
        Selector selector = Selector.open();  
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);  
          
        while (true) {  
              
            //����select�����������ֱ����ע���channel��������  
            selector.select();  
              
            //����ߵ�����з���������channel  
            //����ͨ��selector.selectedKeys().iterator()�õ����������ĵ�����  
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();  
              
            //��������������keys  
            while (keys.hasNext()) {  
                //ȡ��һ��key���Ƴ�  
                SelectionKey key = keys.next();  
                keys.remove();  
                try {  
                    if (key.isAcceptable()) {  
                        //��accept���Է���  
                        //ȡ�ÿ��Բ�����channel  
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();  
                          
                        //����accept����������֣�������ͻ��˿���ͨ�ŵ�channel  
                        SocketChannel channel = server.accept();  
                          
                        //����channel�÷�����  
                        channel.configureBlocking(false);  
                          
                        //ע���selector�����ɶ����дʱ���õ�֪ͨ��select����  
                        channel.register(selector, SelectionKey.OP_READ);  
                    } else if (key.isReadable()) {  
                        //��channel�ɶ�,ȡ���ɶ���channel  
                        SocketChannel channel = (SocketChannel) key.channel();  
                          
                        //������ȡ������,һ�ζ�ȡ1024�ֽ�  
                        ByteBuffer buffer = ByteBuffer.allocate(1024);  
                        channel.read(buffer);  
                          
                        //��ס��������������ʹ�õĴ�С���̶�  
                        buffer.flip();  
                          
                        //������buffer����д��ʹ��  
                        key.attach(buffer);  
                        key.interestOps(SelectionKey.OP_WRITE);  
                    } else if (key.isWritable()) {  
                        //��channel��д,ȡ����д��channel  
                        SocketChannel channel = (SocketChannel) key.channel();  
                          
                        //ȡ���ɶ�ʱ���õĻ�����  
                        ByteBuffer buffer = (ByteBuffer) key.attachment();  
                          
                        //��������ָ���ƶ�����������ʼλ��  
                        buffer.rewind();  
                          
                        //��ȡΪString  
                        String recv = new String(buffer.array());  
                          
                        //��ջ�����  
                        buffer.clear();  
                        buffer.flip();  
                          
                        //д������  
                        byte[] sendBytes = recv.toUpperCase().getBytes();  
                        channel.write(ByteBuffer.wrap(sendBytes));
                    }  
                } catch (IOException e) {  
                    //���ͻ���Socket�ر�ʱ�����ߵ����������Դ  
                    key.cancel();  
                    try {  
                        key.channel().close();  
                    } catch (IOException e1) {  
                        e1.printStackTrace();  
                    }  
                }  
            }  
        }  
    }  
      
    public static void main(String[] args) throws Exception {  
    	CopyOfSocketServerByTCP_NIO server = new CopyOfSocketServerByTCP_NIO();  
        server.startServer(SERVER_IP, SERVER_PORT);  
    }  
}
