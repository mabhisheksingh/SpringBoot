package com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class KafkaApplication {

	static Logger logger = LoggerFactory.getLogger(KafkaApplication.class);
	public static void main(String[] args) {
		logger.info("Kafka started on port... ");
		SpringApplication.run(KafkaApplication.class, args);
	}

}
