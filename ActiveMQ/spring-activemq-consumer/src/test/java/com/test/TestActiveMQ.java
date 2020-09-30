package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestActiveMQ {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext-jms.xml","classpath:applicationContext-service.xml"});
		context.start();
		System.out.println("spring容器启动...");
		System.in.read();
	}

}
