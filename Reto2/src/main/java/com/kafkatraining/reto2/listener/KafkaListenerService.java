package com.kafkatraining.reto2.listener;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafkatraining.reto2.bean.KafkaMessage;

@Service
public class KafkaListenerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaListenerService.class);
	
	@KafkaListener(topics = "alexTopic1")
	public void alexTopic1(KafkaMessage msg) {
		LOGGER.info("Message Received:{}", msg );
	}
}
