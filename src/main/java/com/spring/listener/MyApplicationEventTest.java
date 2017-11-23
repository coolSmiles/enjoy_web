package com.spring.listener;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import com.spring.ApplicationContextUtils;

public class MyApplicationEventTest {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext
				(new String[] {"application.xml","activemq/activemq.xml"});
		
		MyApplicationEvent event = new MyApplicationEvent(applicationContext, "test listener");
		
		applicationContext.publishEvent(event);
		
		ApplicationContext application = ApplicationContextUtils.getApplication();
		
		if(application==applicationContext) {
			System.out.println("success");
		}
	}

}
