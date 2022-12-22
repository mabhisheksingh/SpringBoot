package com.kafkapublisher.KafkaPublisher.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/kafka-producer")
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    //need manual for Config
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    // private final static String TOPIC ="pub-sus";
    private final static String TOPIC ="test";

//    @GetMapping("/produces/{msg}")
//    public String produceText(@PathVariable String msg){
//        kafkaTemplate.send(TOPIC,"Hi "+msg+" welcome");
//        System.out.println("Hi "+msg+" welcome"+"DONE");
//        return "Completed";
//    }

    //for this case for kafkatemplate we need to config manually
    @GetMapping("/produces-json")
    public String produceText(){
       kafkaTemplate.send(TOPIC,"Hi thiis testing ");
        logger.info("This is Controller...");
        System.out.println("Hi "+"data published");
        return "Json published please check...";
    }

}
