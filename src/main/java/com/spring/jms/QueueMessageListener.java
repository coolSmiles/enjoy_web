package com.spring.jms;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消息监听类，负责自动监听MQ中的队列消息
 * @author user
 *
 */
public class QueueMessageListener implements MessageListener {

	/**
	 * 当有消息发送到Destination(队列)中时，自动执行该方法
	 */
	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage)message;
		
		try {
			System.out.println("QueueMessageListener监听到了文本消息："+textMessage.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
