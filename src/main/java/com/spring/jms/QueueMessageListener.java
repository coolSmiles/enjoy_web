package com.spring.jms;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * ��Ϣ�����࣬�����Զ�����MQ�еĶ�����Ϣ
 * @author user
 *
 */
public class QueueMessageListener implements MessageListener {

	/**
	 * ������Ϣ���͵�Destination(����)��ʱ���Զ�ִ�и÷���
	 */
	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage)message;
		
		try {
			System.out.println("QueueMessageListener���������ı���Ϣ��"+textMessage.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
