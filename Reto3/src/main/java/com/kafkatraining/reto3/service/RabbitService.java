package com.kafkatraining.reto3.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafkatraining.reto3.bean.Carrito;
import com.kafkatraining.reto3.bean.Compra;
import com.kafkatraining.reto3.bean.Notification;
import com.kafkatraining.reto3.config.Queues;

@Service
public class RabbitService {

	@Autowired
	private RabbitTemplate rt;
	
	public void sendNotification(Notification notif){
		rt.convertAndSend(Queues.NOTIFICACION, notif);
	} 

	public void sendCompra(Carrito carrito){
		rt.convertAndSend(Queues.CARRITO, carrito);
	} 
	
	public void confirmarCompra(Compra compra){
		rt.convertAndSend(Queues.COMPRA, compra);
	} 

}
