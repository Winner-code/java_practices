package com.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.Serializable;

public class HelloWorldConsumer2 {
    /**
     * 消费消息
     */
    public void readHelloWorldActiveMQ(){
        //定义链接工厂
        ConnectionFactory connectionFactory = null;
        //定义链接对象
        Connection connection = null;
        //定义会话
        Session session = null;
        //目的地
        Destination destination = null;
        //发送者
        MessageConsumer consumer = null;
        // 消息
        Message message = null;

        try{
            /**
             * userName:访问 ActiveMQ 服务的用户名。用户*密码。默认的为 admin。用户名可以通过 jetty-ream. properties 文件进行修改
             * password:访问 ActiveMQ 服务的用户名。用户*密码。默认的为 admin。用户名可以通过 jetty-ream. properties 文件进行修改
             * brokerURL:访问ActiveMQ 服务的路径地址。路径结构为:协议名://主机地址: 端口号
             */
            String username = "admin";
            String password = "admin";
            String brokerURL = "tcp://192.168.1.110:61616" ;
            connectionFactory = new ActiveMQConnectionFactory(username,password,brokerURL);

            //创建链接对象
            connection = connectionFactory.createConnection();

            //启动链接
            connection.start();
            /**
             * transacted:
             *      是否使用事务 可选值为： true|false
             *      true:使用事务当设置此变量值。 Session.SESSION_TRANSACTED
             *      false:不适用事务,设置此变量，则 acknowledgeMode 参数必须设置
             * acknowledgeMode:
             *      Session.AUTO_ACKNOWLEDGE:自动消息确认机制
             *      Session.CLIENT_ACKNOWLEDGE:客户端确认机制
             *      Session.DUPS_OK_ACKNOWLEDGE:有副本的客户端确认消息机制
             */
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

            //创建目的地，即队列的名称，消息的消费者需要通过此名称访问对应的队列
            destination = session.createQueue("my-users");

            //创建消息的消费者
            consumer = session.createConsumer(destination);

            //创建消息对象
            message = consumer.receive();

            //处理消息
            ObjectMessage objMessage = (ObjectMessage)message;
            Users users = (Users)objMessage.getObject();
            System.out.println(users);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //回收消息发送者资源
            if (consumer != null){
                try{
                    consumer.close();
                }catch (JMSException e){
                    e.printStackTrace();
                }
            }
            if (consumer != null){
                try{
                    session.close();
                }catch (JMSException e){
                    e.printStackTrace();
                }
            }
            if (consumer != null){
                try{
                    connection.close();
                }catch (JMSException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
