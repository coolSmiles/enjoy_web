package com.spring.jms;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * 消息消费者
 * @author user
 *
 */
@Service
public class ConsumerService {
	
	@Resource(name="jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	/**
	 * 从队列中接收消息
	 * @param destination
	 * @return
	 */
	public TextMessage receive(Destination destination){
		
		TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);
		String text;
		try {
			if(textMessage!=null){
				text = textMessage.getText();
				System.out.println("从队列" +destination.toString()+ "接收了消息------------" + text);
			}else{
				System.out.println("不存在未被接收的消息");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textMessage;
	}

}
