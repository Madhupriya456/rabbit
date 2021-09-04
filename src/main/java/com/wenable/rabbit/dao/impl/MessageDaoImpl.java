package com.wenable.rabbit.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wenable.rabbit.beans.Message;
import com.wenable.rabbit.dao.MessageDao;
import com.wenable.rabbit.dao.repositories.MessageRepository;

@Repository
public class MessageDaoImpl implements MessageDao {

	@Autowired
	MessageRepository repo;

	@Override
	public Message add(Message bean) {
		return repo.save(bean);
	}

	@Override
	public Message get(String id) {
		return repo.findById(id).orElseThrow();
	}

	@Override
	public Message update(Message bean, String id) {
		Message user=repo.findById(id).orElseThrow(null);
		user.setMessage(bean.getMessage());		
		return repo.save(user);
	}

	@Override
	public void deleteById(String id) {
		repo.deleteById(id);
		
	}
}
