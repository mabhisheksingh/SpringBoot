package com.kafka.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/kafka-producer")
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final static String TOPIC ="test";
    private static final String URL = "https://stream.wikimedia.org/v2/stream/recentchange";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

  

    @GetMapping("/produces/{msg}")
    public String produceText(@PathVariable String msg){
        kafkaTemplate.send(TOPIC,"Hi "+msg+" welcome");
        System.out.println("Hi "+msg+" Welcome");
        return "Completed";
    }

    @GetMapping("/produces-json")
    public String produceText(){
       kafkaTemplate.send(TOPIC,"Hi this testing ");
        logger.info("This is Controller...");
        System.out.println("Hi "+"data published");
        
        
//        HttpClient httpClient = HttpClient.newHttpClient();
//		HttpRequest httpRequest = HttpRequest.newBuilder()
//				.uri(URI.create(URL))
//				.GET()
//				.build();
//		HttpResponse<String> response ;
//		try {
//			response = httpClient.send(httpRequest,
//			        HttpResponse.BodyHandlers.ofString());
//			 System.out.println(response.body());
//		} catch (IOException | InterruptedException e) {
//			e.printStackTrace();
//		}
        return "Json published please check...";
    }

}
