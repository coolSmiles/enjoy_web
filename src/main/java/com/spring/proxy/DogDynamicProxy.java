package com.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ��̬������
 * @author user
 *
 */
public class DogDynamicProxy {
	
	/**
	 * Ŀ��������
	 */
	private Object target;
	
	public DogDynamicProxy(Object target){
		this.target = target;
	}
	
	/**
	 * ���ش������
	 * @return
	 */
	public Object getProxy(){
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				Object result = null;
				System.out.println("����֮ǰִ��");
				result = method.invoke(target, args);
				System.out.println("����֮��ִ��");
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
