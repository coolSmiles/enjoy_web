package com.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("applicationContextUtils")
public class ApplicationContextUtils implements ApplicationContextAware{
	
	private static ApplicationContext application;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ApplicationContextUtils.application = applicationContext;
	}
	
	public static ApplicationContext getApplication() {
		return application;
	}

}
