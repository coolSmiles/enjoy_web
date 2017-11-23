package com.spring.linkedQueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class BlockingQueueUtils {
	
	private static ConcurrentLinkedQueue<String> blockingQueue;
	
	public static ConcurrentLinkedQueue<String> getBlockingQueue() {
		if(blockingQueue == null) {
			blockingQueue = new ConcurrentLinkedQueue<String>();
		}
		
		return blockingQueue;
	}
}
