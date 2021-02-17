package com.placidmasvidal.rabbitmqconsumer.domain.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.placidmasvidal.rabbitmqconsumer.domain.entities.Employee;

//@Service
public class DeadAccountingConsumer {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	private static final Logger LOG = LoggerFactory.getLogger(DeadAccountingConsumer.class);
	
	@RabbitListener(queues = "q.guideline2.accounting.dead")
	public void listen(String message) {
		Employee emp = null;
		try {
			emp = objectMapper.readValue(message, Employee.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		LOG.info("Consuming from accounting dead queue... Employee is {}", emp);
	}
	
}
