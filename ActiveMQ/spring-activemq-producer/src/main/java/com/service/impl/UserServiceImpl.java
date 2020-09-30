package com.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.pojo.Users;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Override
	public void addUser(final Users user) {
		//发送消息
		this.jmsTemplate.send(new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message message = session.createObjectMessage(user);
				return message;
			}
		});
	}

}
