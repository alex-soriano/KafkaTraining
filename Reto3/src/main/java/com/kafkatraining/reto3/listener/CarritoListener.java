package com.kafkatraining.reto3.listener;



import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kafkatraining.reto3.bean.Carrito;
import com.kafkatraining.reto3.bean.Compra;
import com.kafkatraining.reto3.bean.Producto;
import com.kafkatraining.reto3.config.Queues;
import com.kafkatraining.reto3.service.RabbitService;

@Component
public class CarritoListener {
	private static final Logger logger = LoggerFactory.getLogger(CarritoListener.class.getName());
	private Map<Integer,Integer> inventario = Map.of(10, 5, 20, 10, 30, 10, 40, 10, 50, 10);
	
	@Autowired
	private RabbitService rs;
	
	@RabbitListener(queues = Queues.CARRITO)
	public void listen(Carrito in) {
		logger.info("Procesando carrito: {}", in);
		Compra compra = new Compra();
		for(Producto p : in.getProductos()) {
			if (p.getQty()<inventario.get(p.getUpc())) {
				compra.agregarProducto(p);
			}else {
				logger.info("Producto rechazado por falta de inventario: {}-{} ", p.getUpc(), p.getName());
			}
		}
		rs.confirmarCompra(compra);
	}
}
