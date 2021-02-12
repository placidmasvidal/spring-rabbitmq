package com.placidmasvidal.rabbitmqproducer;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.placidmasvidal.rabbitmqproducer.domain.entities.Picture;
import com.placidmasvidal.rabbitmqproducer.domain.producer.MyPictureProducer;

@SpringBootApplication
//@EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner{

	@Autowired
	private MyPictureProducer myPictureProducer;
	
	private final List<String> SOURCES = List.of("mobile", "web");
	
	private final List<String> TYPES = List.of("jpg", "png", "svg");
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
		
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i = 0; i<1; i++) {
			var p = new Picture();
			
			p.setName("Picture" + i);
			p.setSize(ThreadLocalRandom.current().nextLong(9001, 10001));
			p.setSource(SOURCES.get(i % SOURCES.size()));
			p.setType(TYPES.get(i % TYPES.size()));
			
			myPictureProducer.sendMessage(p);
			
		}
	}

}
