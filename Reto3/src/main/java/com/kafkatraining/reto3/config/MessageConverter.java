package com.kafkatraining.reto3.config;

import java.util.List;

import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConverter {
	
	@Bean
	public SimpleMessageConverter converter() {
		SimpleMessageConverter converter = new SimpleMessageConverter();
		converter.setAllowedListPatterns(List.of("com.kafkatraining.reto3.*", "java.util.*"));
		return converter;
	}

}
