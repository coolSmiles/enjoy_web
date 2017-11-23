package com.spring.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * 代理对象
 * @author user
 *
 */
public class CatBehaviorProxy implements MethodInterceptor{

	private Object target;
	
	/**
	 * 创建代理对象
	 */
	public Object getInterance(Object target){
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		// 回调方法
		enhancer.setCallback(this);
		// 创建代理对象
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method mentod, Object[] arg,
			MethodProxy proxy) throws Throwable {
		System.out.println("猫吃鱼之前");
		proxy.invokeSuper(obj, arg);
		System.out.println("猫吃鱼之后");
		return null;
	}
	
	public static void main(String[] args) {
		CatBehavior catBehavior = new CatBehavior();
		CatBehaviorProxy proxy = new CatBehaviorProxy();
		CatBehavior interance =(CatBehavior) proxy.getInterance(catBehavior);
		
		interance.eatFish();
	}
}
