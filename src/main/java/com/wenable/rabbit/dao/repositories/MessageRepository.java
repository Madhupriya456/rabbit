package com.wenable.rabbit.dao.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wenable.rabbit.beans.Message;

public interface MessageRepository extends MongoRepository<Message, String>{

}
