package com.spring.dozer;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;


public class Woman {

	private String name;
	
	private BigDecimal age;
	
	private String like;

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
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
