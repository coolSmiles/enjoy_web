package com.spring.jms;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ��������ģʽ
 * @author user
 *
 */
public class PublisherSubscriberController {
	
	@Resource(name="jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	/**
	 * ������Ϣ publisher-subscribe
	 */
	@ResponseBody
	@RequestMapping(value="/publisher")
	public String publisher(){
		for (int i = 1; i < 6; i++) {
			jmsTemplate.send(new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					TextMessage textMessage = session.createTextMessage();
					// ������Ϣ����
					textMessage.setStringProperty("phone", "110");
					// ������Ϣ����
					textMessage.setText("Hello World");
					return textMessage;
				}
			});
		}
		System.out.println("��Ϣ�������");
		return "success";
	}
	
	/**
	 * ������Ϣ
	 * @param message
	 * @throws JmsException
	 * @throws JMSException
	 */
	public void receive(TextMessage message) throws JmsException, JMSException {  
        System.out.println(message.getText());  
	}  
}
