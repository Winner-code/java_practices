package com.producer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloWorldProducer3 {

	/**
	 * 生产消息
	 */
	public void sendHelloWorldActiveMQ(String msgTest){
		
		//定义链接工厂
		ConnectionFactory connectionFactory = null;
		
		//定义链接对象
		Connection connection = null;
		
		//定义会话
		Session session = null;
		
		//目的地
		Destination destination = null;
		
		//定义消息的发送者
		MessageProducer producer = null;
		
		//定义消息
		Message message = null;
		
		try{
			/**
			 * userName:访问ActiveMQ服务的用户名。用户密码。默认的为admin。用户名可以通过jetty-ream.properties文件进行修改
			 * password:访问ActiveMQ服务的用户名。用户密码。默认的为admin。用户名可以通过jetty-ream.properties文件进行修改
			 * brokerURL:访问ActiveMQ服务的路径地址。路径结构为:协议名://主机地址:端口号
			 */
			connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://192.168.1.110:61616");
		
			//创建连接对象
			connection = connectionFactory.createConnection();
			
			//启动连接
			connection.start();
			
			/**
			 * transacted:是否使用事务 可选值为：true|false
			 *            true:使用事务 当设置次变量值。Session.SESSION_TRANSACTED
			 *            false:不适用事务,设置次变量 则acknowledgeMode参数必须设置
			 * acknowledgeMode:
			 * Session.AUTO_ACKNOWLEDGE:自动消息确认机制
			 * Session.CLIENT_ACKNOWLEDGE:客户端确认机制
			 * Session.DUPS_OK_ACKNOWLEDGE:有副本的客户端确认消息机制
			 */
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//创建目的地，目的地名称即队列的名称。消息的消费者需要通过此名称访问对应的队列
			destination = session.createQueue("my-destination");
			
			//创建消息的生产者 
			producer = session.createProducer(destination);
			
			//创建消息对象
			message = session.createTextMessage(msgTest);
			
			//发送消息
			producer.send(message);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			//回收消息发送者资源
			if(producer != null){
				try {
					producer.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
			if(session != null){
				try {
					session.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
