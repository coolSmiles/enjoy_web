package com.spring.proxy;
/**
 * �������
 * @author user
 *
 */
public class DogStaticProxy implements DogBehavior{
	
	private DogBehavior dogBehavior;
	
	public DogStaticProxy(DogBehavior dogBehavior){
		this.dogBehavior = dogBehavior;
	}
	
	@Override
	public void watchDoor(){
		System.out.println("����֮ǰ");
		dogBehavior.watchDoor();
		System.out.println("����֮��");
	}
	
	
	public static void main(String[] args) {
		
		DogBehavior dogBehavior = new DogBehaviorImpl();
		
		DogStaticProxy proxy = new DogStaticProxy(dogBehavior);
		
		proxy.watchDoor();
	}

	@Override
	public void paly() {
		
	}
}
