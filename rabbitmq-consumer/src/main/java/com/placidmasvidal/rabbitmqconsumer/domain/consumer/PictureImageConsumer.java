package com.placidmasvidal.rabbitmqconsumer.domain.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.placidmasvidal.rabbitmqconsumer.domain.entities.Picture;

@Service
public class PictureImageConsumer {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	private static final Logger LOG = LoggerFactory.getLogger(PictureImageConsumer.class);
	
	@RabbitListener(queues = "q.picture.image")
	public void listen(String message) throws JsonParseException, JsonMappingException, IOException {
		Picture p = null;
			p = objectMapper.readValue(message, Picture.class);
		
		LOG.info("On image: {}", p.toString());
	}
	
}
