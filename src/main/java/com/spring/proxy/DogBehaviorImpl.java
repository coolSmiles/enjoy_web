package com.spring.proxy;

/**
 * 被代理的对象
 * @author user
 *
 */
public class DogBehaviorImpl implements DogBehavior {

	@Override
	public void watchDoor() {
		System.out.println("看门");
	}

	@Override
	public void paly() {
		System.out.println("陪主人玩耍");
	}

}
