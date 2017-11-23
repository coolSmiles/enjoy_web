package com.spring.dozer;

import java.math.BigDecimal;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TestDozer {
	
	@Autowired
	private Mapper mapper;
	
	@Mapping("/dozer/welcome")
	public void welcome(){
		Man man = new Man();
		man.setAge(new BigDecimal("11.20"));
		man.setName("张三");
		man.setEnjoy("tea");
		
		Woman woman = new Woman();
		mapper.map(man, woman);
		
		System.out.println(woman.toString());
	}
	
	
	public static void main(String[] args) {
		
		Man man = new Man();
		
		man.setAge(new BigDecimal("11.20"));
		man.setName("张三");
		man.setEnjoy("tea");
		
		Mapper mapper = new DozerBeanMapper();
		Woman woman = new Woman();
		mapper.map(man, woman);
		
		System.out.println(woman.toString());
		
	}
}
