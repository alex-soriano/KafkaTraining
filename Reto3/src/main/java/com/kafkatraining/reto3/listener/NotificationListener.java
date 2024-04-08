package com.kafkatraining.reto3.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.kafkatraining.reto3.bean.Notification;
import com.kafkatraining.reto3.config.Queues;
import com.kafkatraining.reto3.service.EmailService;

@Component
public class NotificationListener {
	private static final Logger logger = LoggerFactory.getLogger(NotificationListener.class.getName());
	
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private RedisTemplate<String, Notification> redisTemplate;

    @RabbitListener(queues = Queues.NOTIFICACION)
    public void listen(Notification in) {
    	logger.info("Procesando notificacion: {}", in);
//    	emailService.sendSimpleMessage(in.getTo(),in.getSubject(), in.getBody() );
    	redisTemplate.opsForValue().set(in.getTo(), in);
    	logger.info("Guardado a Redis:", in);
    }
    
    
}
