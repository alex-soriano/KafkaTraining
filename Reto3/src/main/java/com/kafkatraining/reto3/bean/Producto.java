package com.kafkatraining.reto3.bean;

import java.io.Serializable;

public class Producto implements Serializable{
	private int upc;
	private String name;
	private int qty;
	
	public int getUpc() {
		return upc;
	}
	public void setUpc(int upc) {
		this.upc = upc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	@Override
	public String toString() {
		return "Producto [upc=" + upc + ", name=" + name + ", qty=" + qty + "]";
	}
	
	
}
