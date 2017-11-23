package com.spring;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController{
	
	
	public HelloWorldController(){
		System.out.println("hello world 初始化执行了。。。。");
	}

	@RequestMapping(value="/welcomes")
	public ModelAndView handleRequests(
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("执行。。。。");
		ModelAndView model = new ModelAndView();
		
		model.setViewName("welcome");
		
		// 获取spring容器上下文
		ServletContext servletContext = request.getSession().getServletContext();
		WebApplicationContextUtils.getWebApplicationContext(servletContext);
		WebApplicationContextUtils.findWebApplicationContext(servletContext);
		return model;
	}
	
	@SuppressWarnings("static-access")
	@ResponseBody
	@RequestMapping(value="/hello")
	public String hello(){
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "abc--->"+Thread.currentThread().getName();
	}
	
	@ResponseBody
	@RequestMapping(value="/world")
	public Map<String, String> world(){
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "ac");
		map.put("2", "abc");
		map.put("3", "aec");
		return map;
	}

	@ResponseBody
	@RequestMapping(value="/user")
	public User user(){
		User user = new User();
		user.setAge("11");
		user.setName("zhangsan");
		return user;
	}
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
		
		User user = (User) applicationContext.getBean("user");
		System.out.println(user.toString());
		
	}
}
