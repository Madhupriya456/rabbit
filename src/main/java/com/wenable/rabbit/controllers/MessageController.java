package com.wenable.rabbit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wenable.rabbit.beans.Message;
import com.wenable.rabbit.service.MessageService;

@RestController
@RequestMapping("/user")
public class MessageController {
	
	@Autowired
	MessageService service;
	
	@PostMapping("/create")
	public ResponseEntity<Message> addMessage(@RequestBody Message bean)
	{
		Message user=service.add(bean);
		return ResponseEntity.ok(user);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Message> getUserMessage(@PathVariable String id)
	{
		Message user=service.getUserMessage(id);
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Message> updateMessage(@PathVariable String id,@RequestBody Message bean)
	{
		Message user=service.update(bean,id);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMessage(@PathVariable String id)
	{
		service.delete(id);	
	}
}
