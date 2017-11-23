package com.spring.linkedQueue;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class AppleProducer implements InitializingBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		new AppleConsumer().start();
	}

	private class AppleConsumer extends Thread{

		@SuppressWarnings("static-access")
		@Override
		public void run() {
			while(true) {
				try {
					Thread.currentThread().sleep(1000*5);
					// String take = BlockingQueueUtils.getBlockingQueue().take();
					String take = BlockingQueueUtils.getBlockingQueue().poll();
					System.out.println("from blocking queue get message:"+take);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
