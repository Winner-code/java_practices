package com.springredis;

import com.springredis.jedisdao.JedisDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Test {

	public static void main(String[] args) {
		Test.testJedisSingle();
//		Test.testJedisCluster();
	}

	/**
	 * 测试单机版Jedis
	 */
	public static void testJedisSingle(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-Jedis.xml");
		JedisDao jd = (JedisDao)ac.getBean("jedisDaoImplSingle");
		String str = jd.set("hello", "Redis");
		System.out.println(str);
		String result = jd.get("hello");
		System.out.println(result);
	}
	
	/**
	 * 测试集群版Jedis
	 */
	public static void testJedisCluster(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-Jedis.xml");
		JedisDao jd = (JedisDao)ac.getBean("jedisDaoImplCluster");
		String str = jd.set("bjsxt", "baizhan");
		System.out.println(str);
		String result = jd.get("bjsxt");
		System.out.println(result);
	}
}
