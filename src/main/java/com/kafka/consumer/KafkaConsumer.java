package com.kafka.consumer;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "test" , groupId = "myGroup")
    public void consume(String message){
        logger.info(String.format("Message recived --> %s", message));
        System.out.println("Message consume from listner : "+ message);
    }
}
