package edu.huce.chatappbe.config.ws;


import edu.huce.chatappbe.config.HttpHandshakeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.HandshakeHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.xml.crypto.Data;


@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    HttpHandshakeInterceptor httpHandshakeInterceptor;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry
                .addHandler(getDataHandler(), "/data").setAllowedOrigins("*")
                .addInterceptors(new HttpSessionHandshakeInterceptor());

    }

    @Bean
    DataHandler getDataHandler() {
        return new DataHandler();
    }

}
