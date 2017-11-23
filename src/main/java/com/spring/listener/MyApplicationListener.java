package com.spring.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyApplicationListener implements ApplicationListener<ApplicationEvent>{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof MyApplicationEvent) {
			MyApplicationEvent myEvent = (MyApplicationEvent)event;
			
			myEvent.print();
		}
	}

}
