package com.spring;


public class User {
	
	public User(){
		System.out.println("��ʼ��ִ�����ˡ�����");
	};
	
	private String name;
	
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
