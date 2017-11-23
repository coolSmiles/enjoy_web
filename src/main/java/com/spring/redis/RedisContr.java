package com.spring.redis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RedisContr {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:application.xml",
				"classpath:/redis/cluster-redis.xml");
		SpringDao bean = applicationContext.getBean(SpringDao.class);
		
		// bean.put("name", "zhangsan");
		
		String name = bean.get("name");
		
		System.out.println(name);
	}

}
