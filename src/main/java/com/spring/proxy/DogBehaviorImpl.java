package com.spring.proxy;

/**
 * ������Ķ���
 * @author user
 *
 */
public class DogBehaviorImpl implements DogBehavior {

	@Override
	public void watchDoor() {
		System.out.println("����");
	}

	@Override
	public void paly() {
		System.out.println("��������ˣ");
	}

}
