package com.wenable.rabbit.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.wenable.rabbit.configuration.MessageConfig;

@Component
public class MessageListener {

	@RabbitListener(queues= MessageConfig.QUEUE)
	public void consumer( String message)
	{
		try {
			process(message);
		}
		catch(Exception e)
		{
			
		}
	}

	private void process(String message) {
		System.out.println("Message recevied: "+ message);		
	}
}
