package com.wenable.rabbit.service;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wenable.rabbit.beans.Message;
import com.wenable.rabbit.configuration.MessageConfig;
import com.wenable.rabbit.dao.MessageDao;

@Service
public class MessageService {

	@Autowired
	MessageDao dao;
	
	@Autowired
	RabbitTemplate template;

	public Message add(Message bean) {
		template.convertAndSend(MessageConfig.EXCHANGE,MessageConfig.QUEUE,bean.getMessage());
		return dao.add(bean);
	}

	public Message getUserMessage(String id) {
		return dao.get(id);
	}

	public Message update(Message bean, String id) {
		template.convertAndSend(MessageConfig.EXCHANGE,MessageConfig.QUEUE,bean.getMessage());
		return dao.update(bean,id);
	}

	public void delete(String id) {
		dao.deleteById(id);
		
	}
	
}
