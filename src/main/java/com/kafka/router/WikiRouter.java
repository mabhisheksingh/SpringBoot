package com.kafka.router;

import com.kafka.handler.WikiHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class WikiRouter {

    @Autowired
    private WikiHandler wikiHandler;
    @Bean
    public RouterFunction<ServerResponse> kafkaRouterFunction(){
        return RouterFunctions.route()
                .GET("/test", wikiHandler::getTestResponse)
                .GET("/start-event", wikiHandler::getWikiMediaStream)
                .build();
    }

}
