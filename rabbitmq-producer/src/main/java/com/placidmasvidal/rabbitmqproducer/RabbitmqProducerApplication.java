package com.placidmasvidal.rabbitmqproducer;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.placidmasvidal.rabbitmqproducer.domain.entities.Employee;
import com.placidmasvidal.rabbitmqproducer.domain.producer.HumanResourceProducer;

@SpringBootApplication
//@EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner{

	@Autowired
	private HumanResourceProducer humanResourceProducer;
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
		
		
		
	}

	@Override
	public void run(String... args) throws Exception {
//		helloRabbitProducer.sendHello("Placid " + Math.random());
		for(int i = 0; i<5; i++) {
			var e = new Employee("emp " + i, "Employee " + i, LocalDate.now());
			humanResourceProducer.sendMessage(e);
		}
	}

}
