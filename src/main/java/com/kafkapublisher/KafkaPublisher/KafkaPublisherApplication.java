package com.kafkapublisher.KafkaPublisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaPublisherApplication {

	static Logger logger = LoggerFactory.getLogger(KafkaPublisherApplication.class);
	public static void main(String[] args) {
		logger.info("KafkaPublisherApplication started on port... ");
		SpringApplication.run(KafkaPublisherApplication.class, args);
	}

}
