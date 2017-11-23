package com.spring.dozer;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;


public class Man {

	private String name;
	
	private BigDecimal age;
	
	private String enjoy;

	public String getEnjoy() {
		return enjoy;
	}

	public void setEnjoy(String enjoy) {
		this.enjoy = enjoy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAge() {
		return age;
	}

	public void setAge(BigDecimal age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
