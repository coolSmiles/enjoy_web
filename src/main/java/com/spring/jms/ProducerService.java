package com.spring.jms;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 * 消息生产者
 * @author user
 *
 */
@Service
public class ProducerService {
	
	@Resource(name="jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	/**
	 * 向默认队列发送消息
	 * @param msg
	 */
	public void sendMessage(final String msg){
		
		Destination destination = jmsTemplate.getDefaultDestination();
		
		System.out.println("向队列" +destination.toString()+ "发送了消息------------" + msg);
		
		jmsTemplate.send(new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}
	
	
	/**
	 * 向指定队列发送消息
	 * @param destination
	 * @param msg
	 */
	public void sendMessage(Destination destination,final String msg){

		System.out.println("向队列" +destination.toString()+ "发送了消息------------" + msg);
		
		jmsTemplate.send(new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}

}
