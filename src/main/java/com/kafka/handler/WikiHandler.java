package com.kafka.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class WikiHandler {

    Logger logger = LoggerFactory.getLogger(WikiHandler.class);
    private final static String TOPIC ="test";
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private static final String URL = "https://stream.wikimedia.org/v2/stream/recentchange";
    @Autowired
    private WebClient webClient;

    public Mono<ServerResponse> getWikiMediaStream(ServerRequest serverRequest){
        Flux<String> flux = webClient.get()
                .uri(URL)
                .retrieve()
                .bodyToFlux(String.class);
        flux.subscribe(event ->{
            System.out.println("stream data "+ event );
            kafkaTemplate.send(TOPIC, event );
        });
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(flux,String.class);

    }

    public Mono<ServerResponse> getTestResponse(ServerRequest serverRequest){
        logger.info(String.valueOf(serverRequest));
        Mono<String> str = Mono.just("This is Test folder");
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(str, String.class);
    }




}
