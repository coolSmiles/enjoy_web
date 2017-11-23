package com.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类
 * @author user
 *
 */
public class DogDynamicProxy {
	
	/**
	 * 目标代理对象
	 */
	private Object target;
	
	public DogDynamicProxy(Object target){
		this.target = target;
	}
	
	/**
	 * 返回代理对象
	 * @return
	 */
	public Object getProxy(){
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				Object result = null;
				System.out.println("看门之前执行");
				result = method.invoke(target, args);
				System.out.println("看门之后执行");
				return result;
			}
		});
	}
	
	
	public static void main(String[] args) {
		DogBehavior dogBehavior = new DogBehaviorImpl();
		
		DogDynamicProxy proxy = new DogDynamicProxy(dogBehavior);
		
		DogBehavior dog = (DogBehavior) proxy.getProxy();
		
		dog.watchDoor();
		
		dog.paly();
	}
}
