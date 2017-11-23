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
 * ��Ϣ������
 * @author user
 *
 */
@Service
public class ProducerService {
	
	@Resource(name="jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	/**
	 * ��Ĭ�϶��з�����Ϣ
	 * @param msg
	 */
	public void sendMessage(final String msg){
		
		Destination destination = jmsTemplate.getDefaultDestination();
		
		System.out.println("�����" +destination.toString()+ "��������Ϣ------------" + msg);
		
		jmsTemplate.send(new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}
	
	
	/**
	 * ��ָ�����з�����Ϣ
	 * @param destination
	 * @param msg
	 */
	public void sendMessage(Destination destination,final String msg){

		System.out.println("�����" +destination.toString()+ "��������Ϣ------------" + msg);
		
		jmsTemplate.send(new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}

}
