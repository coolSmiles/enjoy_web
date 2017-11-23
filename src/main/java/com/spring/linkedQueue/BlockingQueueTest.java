package com.spring.linkedQueue;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

public class BlockingQueueTest {
	
	public static void main(String[] args) throws Exception {
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext
				(new String[] {"application.xml","activemq/activemq.xml"});
		
		ConcurrentLinkedQueue<String> blockingQueue = BlockingQueueUtils.getBlockingQueue();
		for (int i = 1; i <= 2; i++) {
			// blockingQueue.put("��Ϣ00"+i);
			blockingQueue.offer("��Ϣ00"+i);
			System.out.println("from blocking queue put message:��Ϣ00"+i);
		}
	}

}
