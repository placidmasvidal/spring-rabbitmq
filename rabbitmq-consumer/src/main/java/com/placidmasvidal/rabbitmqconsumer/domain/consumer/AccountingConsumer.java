package com.placidmasvidal.rabbitmqconsumer.domain.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.placidmasvidal.rabbitmqconsumer.domain.entities.Employee;

//@Service
public class AccountingConsumer {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	private static final Logger LOG = LoggerFactory.getLogger(AccountingConsumer.class);
	
	@RabbitListener(queues = "q.hr.accounting")
	public void listen(String message) {
		Employee emp = null;
		try {
			emp = objectMapper.readValue(message, Employee.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		LOG.info("On accounting, employee is {}", emp);
	}
	
}
