package com.spring.proxy;
/**
 * 代理对象
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
		System.out.println("看门之前");
		dogBehavior.watchDoor();
		System.out.println("看门之后");
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
