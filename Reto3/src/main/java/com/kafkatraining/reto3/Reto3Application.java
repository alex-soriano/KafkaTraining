package com.kafkatraining.reto3;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kafkatraining.reto3.bean.Carrito;
import com.kafkatraining.reto3.bean.Producto;
import com.kafkatraining.reto3.service.RabbitService;

@SpringBootApplication
public class Reto3Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto3Application.class, args);
	}

	@Bean
	public ApplicationRunner runner(RabbitService rs) {
		return args -> {
			Carrito carrito = new Carrito();
			Producto prd = new Producto();
			prd.setUpc(10);
			prd.setName("Leche");
			prd.setQty(10);
			carrito.agregarProducto(prd);
			
			prd = new Producto();
			prd.setUpc(20);
			prd.setName("Jugo");
			prd.setQty(2);
			carrito.agregarProducto(prd);
			
			prd = new Producto();
			prd.setUpc(30);
			prd.setName("Cafe");
			prd.setQty(1);
			carrito.agregarProducto(prd);

			prd = new Producto();
			prd.setUpc(40);
			prd.setName("Azucar");
			prd.setQty(4);
			carrito.agregarProducto(prd);
	        rs.sendCompra(carrito);
		};
	}

}
