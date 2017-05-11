package com.erbal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     * Configure Topic where clients subscribe (server push data in this channel)
     * Configure context-path where clients push data to server
     * @param config
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {

        //topic notifications (ex. ItsMe, MissingNode, lowBattery, ..)
        config.enableSimpleBroker("/topic/notifications");
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * Settings WebSockets Endpoint with CORS and SockJS
     * (where clients connect for open the websocket)
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        registry.addEndpoint("/websockets").setAllowedOrigins("*").withSockJS();
    }
}