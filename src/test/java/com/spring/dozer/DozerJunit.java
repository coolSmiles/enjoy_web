package com.spring.dozer;

import java.math.BigDecimal;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application.xml","classpath:spring-servlet.xml" ,"classpath:dozer/*"})
public class DozerJunit {
	
	@Autowired
	private Mapper mapper;
	@Test
	public void test() {
		Man man = new Man();
		man.setAge(new BigDecimal("11.20"));
		man.setName("ÕÅÈý");
		man.setEnjoy("tea");
		
		Woman woman = new Woman();
		mapper.map(man, woman);
		
		System.out.println(woman.toString());
	}

}
