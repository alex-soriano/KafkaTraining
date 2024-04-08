package com.kafkatraining.reto3.listener;



import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kafkatraining.reto3.bean.Compra;
import com.kafkatraining.reto3.bean.Notification;
import com.kafkatraining.reto3.bean.Producto;
import com.kafkatraining.reto3.config.Queues;
import com.kafkatraining.reto3.service.RabbitService;

@Component
public class CompraListener {
	private static final Logger logger = LoggerFactory.getLogger(CompraListener.class.getName());
	
	@Autowired
	private RabbitService rs;
	private Random r = new Random();
	
	@RabbitListener(queues = Queues.COMPRA)
	public void listen(Compra in) {
		logger.info("Procesando compra: {}", in);
		StringBuilder body = new StringBuilder();
		
		body.append("Compra Exitosa: \n\r");
		
		for(Producto p : in.getProductos()) {
			body.append(p.getQty()).append(" - ").append(p.getName()).append("\n\r");
		}
		
		Notification notif = new Notification();
		notif.setBody(body.toString());
		notif.setSubject("Compra exitosa");
		notif.setTo("client"+r.nextInt(1, 1000)+"@gmail.com");
		rs.sendNotification(notif);
	}
}
