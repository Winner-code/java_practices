package com.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloWorldConsumer3 {

	/**
	 * 消费消息
	 */
	public void readHelloWorldActiveMQ() {

		// 定义链接工厂
		ConnectionFactory connectionFactory = null;

		// 定义链接对象
		Connection connection = null;

		// 定义会话
		Session session = null;

		// 目的地
		Destination destination = null;

		// 定义消息的发送者
		MessageConsumer consumer = null;

		// 定义消息
		Message message = null;

		try {
			/**
			 * userName:访问ActiveMQ服务的用户名。用户密码。默认的为admin。用户名可以通过jetty-ream.
			 * properties文件进行修改
			 * password:访问ActiveMQ服务的用户名。用户密码。默认的为admin。用户名可以通过jetty-ream.
			 * properties文件进行修改 brokerURL:访问ActiveMQ服务的路径地址。路径结构为:协议名://主机地址:端口号
			 */
			connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://192.168.1.110:61616");

			// 创建连接对象
			connection = connectionFactory.createConnection();

			// 启动连接
			connection.start();

			/**
			 * transacted:是否使用事务 可选值为：true|false true:使用事务
			 * 当设置次变量值。Session.SESSION_TRANSACTED false:不适用事务,设置次变量
			 * 则acknowledgeMode参数必须设置 acknowledgeMode:
			 * Session.AUTO_ACKNOWLEDGE:自动消息确认机制
			 * Session.CLIENT_ACKNOWLEDGE:客户端确认机制
			 * Session.DUPS_OK_ACKNOWLEDGE:有副本的客户端确认消息机制
			 */
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// 创建目的地，目的地名称即队列的名称。消息的消费者需要通过此名称访问对应的队列
			destination = session.createQueue("my-destination");

			// 创建消息的消费者
			consumer = session.createConsumer(destination);

			consumer.setMessageListener(

					new MessageListener() {
				
				//ActiveMQ 回调的方法。通过该方法将消息传递到 consumer
				@Override
				public void onMessage(Message message) {
					//处理消息
					String msg=null;
					try {
						msg = ((TextMessage)message).getText();
					} catch (JMSException e) {
						e.printStackTrace();
					}
					System.out.println("从ActiveMQ服务中获取的文本信息 "+msg);
				}
			});

			

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
