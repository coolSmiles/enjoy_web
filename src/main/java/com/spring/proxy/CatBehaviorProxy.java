package com.spring.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * �������
 * @author user
 *
 */
public class CatBehaviorProxy implements MethodInterceptor{

	private Object target;
	
	/**
	 * �����������
	 */
	public Object getInterance(Object target){
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		// �ص�����
		enhancer.setCallback(this);
		// �����������
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method mentod, Object[] arg,
			MethodProxy proxy) throws Throwable {
		System.out.println("è����֮ǰ");
		proxy.invokeSuper(obj, arg);
		System.out.println("è����֮��");
		return null;
	}
	
	public static void main(String[] args) {
		CatBehavior catBehavior = new CatBehavior();
		CatBehaviorProxy proxy = new CatBehaviorProxy();
		CatBehavior interance =(CatBehavior) proxy.getInterance(catBehavior);
		
		interance.eatFish();
	}
}
