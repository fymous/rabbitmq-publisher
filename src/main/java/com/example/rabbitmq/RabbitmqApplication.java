package com.example.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** publisher */
@SpringBootApplication
public class RabbitmqApplication implements CommandLineRunner {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleMessage simpleMessage = new SimpleMessage();
		simpleMessage.setName("Simple Message");
		simpleMessage.setDescription("Simple Description");
		
		//Exchange Name - MyTopicExchange from rabbitmq subscriber
		//RoutingKey - tpoicRouting also confgigured in subscriber
		rabbitTemplate.convertAndSend("MyTopicExchnage", "topicRouting", 
						simpleMessage);
	}

}
