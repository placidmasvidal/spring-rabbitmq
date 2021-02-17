package com.placidmasvidal.rabbitmqproducer;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.placidmasvidal.rabbitmqproducer.domain.entities.Employee;
import com.placidmasvidal.rabbitmqproducer.domain.producer.RetryEmployeeProducer;

@SpringBootApplication
//@EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner{
		
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);	
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
