package com.wenable.rabbit.dao;



import com.wenable.rabbit.beans.Message;

public interface MessageDao {

	Message add(Message bean);

	Message get(String id);

	Message update(Message bean, String id);

	void deleteById(String id);
	

}
