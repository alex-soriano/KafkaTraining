package com.kafkatraining.reto2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.kafkatraining.reto2.bean.KafkaMessage;
import com.kafkatraining.reto2.service.KafkaService;

@SpringBootApplication
public class Reto2Application {

	public static void main(String[] args) {
	    // Launch the application
	    ConfigurableApplicationContext context = SpringApplication.run(Reto2Application.class, args);

	    KafkaService kafkaService = context.getBean(KafkaService.class);
	    
	    KafkaMessage km = new KafkaMessage();
	    km.setMessageText("Test 1");
	    km.setMessageValue(10);
	    km.setBoolValue(false);
	    kafkaService.sendMessage(km);
	    
	    km = new KafkaMessage();
	    km.setMessageText("Test 2");
	    km.setMessageValue(20);
	    km.setBoolValue(true);
	    kafkaService.sendMessage(km);
	}

}
