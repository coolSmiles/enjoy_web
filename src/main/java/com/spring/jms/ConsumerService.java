package com.spring.jms;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * ��Ϣ������
 * @author user
 *
 */
@Service
public class ConsumerService {
	
	@Resource(name="jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	/**
	 * �Ӷ����н�����Ϣ
	 * @param destination
	 * @return
	 */
	public TextMessage receive(Destination destination){
		
		TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);
		String text;
		try {
			if(textMessage!=null){
				text = textMessage.getText();
				System.out.println("�Ӷ���" +destination.toString()+ "��������Ϣ------------" + text);
			}else{
				System.out.println("������δ�����յ���Ϣ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textMessage;
	}

}
