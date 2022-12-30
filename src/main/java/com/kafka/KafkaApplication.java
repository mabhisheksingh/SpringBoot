package com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class KafkaApplication {

	static Logger logger = LoggerFactory.getLogger(KafkaApplication.class);

	@Bean
	public WebClient webClient() { return WebClient.create(); }
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

}
