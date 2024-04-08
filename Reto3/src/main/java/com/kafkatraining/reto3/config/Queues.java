package com.kafkatraining.reto3.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Queues {
	
	public static final String CARRITO = "carrito";
	public static final String COMPRA = "compra";
	public static final String NOTIFICACION = "notificacion";
	
	

	@Bean
    public Queue carritoQueue() {
        return new Queue(CARRITO, true);
    }
	
	@Bean
    public Queue compraQueue() {
        return new Queue(COMPRA, true);
    }
	
	@Bean
    public Queue notificacionQueue() {
        return new Queue(NOTIFICACION, true);
    }
}
