package com.kafkatraining.reto2.bean;

public class KafkaMessage {
	private String messageText;
	private int messageValue;
	private boolean boolValue;
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public int getMessageValue() {
		return messageValue;
	}
	public void setMessageValue(int messageValue) {
		this.messageValue = messageValue;
	}
	public boolean isBoolValue() {
		return boolValue;
	}
	public void setBoolValue(boolean boolValue) {
		this.boolValue = boolValue;
	}
	@Override
	public String toString() {
		return "KafkaMessage [messageText=" + messageText + ", messageValue=" + messageValue + ", boolValue="
				+ boolValue + "]";
	}
	
	
	
}
