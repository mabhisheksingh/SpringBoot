package com.kafkapublisher.KafkaPublisher.controller;

import com.kafkapublisher.KafkaPublisher.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/kafka-producer")
public class HomeController {


//    //by default no need for config
//    @Autowired
//    private KafkaTemplate<String,Object> kafkaTemplate;

    //need manual for config
    @Autowired
    private KafkaTemplate<String,Employee> kafkaTemplate;

    private final static String TOPIC ="pub-sus";

//    @GetMapping("/produces/{msg}")
//    public String produceText(@PathVariable String msg){
//        kafkaTemplate.send(TOPIC,"Hi "+msg+" welcome");
//        System.out.println("Hi "+msg+" welcome"+"DONE");
//        return "Completed";
//    }

    //for this case for kafkatemplate we need to config manually
    @GetMapping("/produces-json")
    public String produceText(){
        kafkaTemplate.send(TOPIC,new Employee(1L,"Abhishek","7271058852"));
        System.out.println("Hi "+"data published");
        return "Json published please check...";
    }

}
