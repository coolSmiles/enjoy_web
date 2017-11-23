package com.spring.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class MyApplicationLinstener4ContextRefreshedEvent implements ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("spring application初始化完成");
	}

}
