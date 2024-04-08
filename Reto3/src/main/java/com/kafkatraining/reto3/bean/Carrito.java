package com.kafkatraining.reto3.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Carrito implements Serializable {
	private List<Producto> productos = new ArrayList<>();

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}

	@Override
	public String toString() {
		return "Carrito [productos=" + productos + "]";
	}
	
	
}
