package com.placidmasvidal.rabbitmqproducer.util;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqScheduler {

	private static final Logger LOG = LoggerFactory.getLogger(RabbitmqScheduler.class);
	
	@Autowired
	private RabbitmqProxyService rabbitmqProxyService;
	
	@Scheduled(fixedDelay = 90000)
	public void sweepDirtyQueues() {
		try {
			var dirtyQueues = rabbitmqProxyService.getAllQueues()
					.stream()
					.filter(p -> p.isDirty())
					.collect(Collectors.toList());
			dirtyQueues.forEach(q -> LOG.info("Queue {} has {} unprocessed messages", q.getName(), q.getMessages()));
		} catch (Exception e) {
			LOG.error("Cannot sweep queues: {} ", e.getMessage());
		}
	}
	
}
