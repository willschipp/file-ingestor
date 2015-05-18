package com.emc.data.service;

import org.apache.commons.logging.*;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQMessageService implements MessageService {

	private static final Log logger = LogFactory.getLog(RabbitMQMessageService.class);

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("${routing.key}")
	private String routingKey;
	
	@Override
	public void send(Object payload) {
		logger.info(payload);
		MessageProperties properties = new MessageProperties();
		properties.setContentType("text/plain");
		Message message = new Message(payload.toString().getBytes(),properties);
		rabbitTemplate.send(routingKey,message);
	}

}
