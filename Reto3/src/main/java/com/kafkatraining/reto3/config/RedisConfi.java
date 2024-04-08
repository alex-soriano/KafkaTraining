package com.kafkatraining.reto3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.kafkatraining.reto3.bean.Notification;

@Configuration
public class RedisConfi {

	@Bean
	public RedisTemplate<String, Notification> notifRedisTemplae(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Notification> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}
}
