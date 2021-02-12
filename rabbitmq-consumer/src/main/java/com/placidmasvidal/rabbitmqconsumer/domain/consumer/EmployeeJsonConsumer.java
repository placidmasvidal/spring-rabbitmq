package com.placidmasvidal.rabbitmqconsumer.domain.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.placidmasvidal.rabbitmqconsumer.domain.entities.Employee;

//@Service
public class EmployeeJsonConsumer {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeJsonConsumer.class);
	
	@RabbitListener(queues = "course.employee")
	public void listen(String message) {
		Employee emp;
		try {
			emp = objectMapper.readValue(message, Employee.class);
			LOG.info("Employee is {}", emp);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
