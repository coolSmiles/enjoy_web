package com.spring.listener;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
public class MyApplicationEvent extends ApplicationEvent{
	
	private String title ;

	public MyApplicationEvent(Object source) {
		super(source);
	}
	
	public MyApplicationEvent(Object source ,String title) {
		super(source);
		this.title = title;
	}
	
	public void print() {
		 System.out.println("title="+title);
	}

	
}
