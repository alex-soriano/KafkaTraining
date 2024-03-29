package com.kafkatraining.reto2.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kafkatraining.reto2.bean.KafkaMessage;


@Service
public class KafkaService {
	

    private KafkaTemplate<String, KafkaMessage> kafkaTemplate;
    
    public KafkaService(KafkaTemplate<String, KafkaMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
	
	public void sendMessage(KafkaMessage km) {

        Message<KafkaMessage> message = MessageBuilder
                .withPayload(km)
                .setHeader(KafkaHeaders.TOPIC, "alexTopic1")
                .build();

        kafkaTemplate.send(message);
	}

}
